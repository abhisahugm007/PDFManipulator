package com.codeplanet.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.codeplanet.model.User;
import com.codeplanet.model.UserFile;
import com.codeplanet.model.UserRegister;
import com.codeplanet.model.UserLogin;
import com.codeplanet.model.userProtection;
import com.codeplanet.service.HomeService;

@Controller
public class HomeController {
@Autowired
HomeService homeService;

	@RequestMapping(value="/")
	public String home(UserRegister user,HttpServletResponse res) throws SQLException, IOException
	{
		System.out.println("controller called");
		homeService.insertInfo(user,res);
		return "index1";
	}
	@RequestMapping(value="/xyz")
	public String xyz(User user,HttpServletRequest req) throws SQLException
	{
		System.out.println("controller called");
		ArrayList<User> l=new ArrayList<User>();
		int i=0;
		while(i<=3) {
			User u=new User();
			u.setEmail("code");
			u.setPassword("abhi99");
			l.add(u);
			i++;
		}
		req.setAttribute("xyz", l);
		return "jstl";
	}
	
	@RequestMapping(value="/merge")
	public String merge()
	{
		return "merge";
	}
	@RequestMapping(value="/mergePdf",method=RequestMethod.POST)
	public String mergePdf(HttpServletRequest req,UserFile user ) throws SQLException, IOException
	{
		String s1=user.getName();
		ArrayList<String> filePath=uploadFileOnServer(user);
		merger(filePath,req);
		System.out.println("test controller called"+"  "+s1);
		return "download";
	}
	
	
	public void merger(ArrayList<String> filePath, HttpServletRequest req) throws IOException {
		PDFMergerUtility pdf= new PDFMergerUtility();
		File f1 = new File("D:/files/merge/merge.pdf");
	    f1.createNewFile();
		pdf.setDestinationFileName(f1.getCanonicalPath());
		for(String s:filePath)
		{
			pdf.addSource(s);
		}	
	pdf.mergeDocuments(null);
	System.out.println("pdf merged");
	req.setAttribute("f1", f1.getCanonicalPath());
		
	}

	
	private ArrayList<String> uploadFileOnServer(UserFile user) {
	
		String rootdirectory="D:/files/merge";
		File directory= new File(rootdirectory);
		if(!directory.exists())
			directory.mkdirs();
		MultipartFile[] f=user.getUserfiles();
		String filepath=null;
		ArrayList<String> list= new ArrayList<String>();
		for(MultipartFile filedata:f)
		{
			String filename=filedata.getOriginalFilename();

			if(filename!=null && filename.length()>0)
			{
				try {
					filepath=directory.getCanonicalPath() + File.separator+filename;
					BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(filepath));
					bos.write(filedata.getBytes());
					bos.close();
					list.add(filepath);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
}
	
	
	//login and register credential
	@RequestMapping(value="/testLogin")
	public String testLogin(HttpServletRequest req,HttpServletResponse res,UserLogin user) throws IOException
	{
		homeService.getInfo(user,res);
		return "index1";
	}
	@RequestMapping(value="/RegisterUi")
	public String RegisterUi()
	{
		return "RegisterUi";
	}
	@RequestMapping(value="/testRegister")
	public String testRegister(HttpServletRequest req,HttpServletResponse res,UserRegister user) throws IOException, SQLException
	{
		PrintWriter pw=res.getWriter();
		String flag=homeService.insertInfo(user,res);
		while(flag!="0") {
			pw.println("Email alredy exsist!");
			flag=homeService.insertInfo(user,res);
		}
		return "index1";
	}
	
	
	
	@RequestMapping(value="/download",method=RequestMethod.POST)
	public String download(HttpServletResponse res,HttpServletRequest req) throws IOException
	{
		String mimeType=null;
		String file=req.getParameter("filepath");
		File f=new File(file);
		mimeType=getMimeType(f.getCanonicalPath());
		res.setContentType(mimeType);
		res.setHeader("Content-Disposition", "attachement;filename=\""+f.getName()+"\"");
		res.setContentLength((int)f.length());
		InputStream is =new FileInputStream(f);
		ServletOutputStream out=res.getOutputStream();
		IOUtils.copy(is,out);
		is.close();
		out.flush();
		out.close();
		return "index1";
	}
	private String getMimeType(String canonicalPath) {
		canonicalPath=canonicalPath.toLowerCase();
		if(canonicalPath.endsWith(".jpg") || canonicalPath.endsWith(".jpeg") ||canonicalPath.endsWith(".jpe") )
			return "image/jpeg";
		else if(canonicalPath.endsWith(".pdf"))
			return "application/pdf";
		else
			return"";
	}

	/*
	 * //22/06/2020
	 * 
	 * @RequestMapping(value="/splitter", produces="application/zip") public String
	 * splitter(HttpServletResponse res,HttpServletRequest req) throws IOException {
	 * File file=new File("D:/files/merge/code.pdf"); PDDocument
	 * pd=PDDocument.load(file); Splitter sp=new Splitter(); List<PDDocument>
	 * pd1=sp.split(pd); Iterator<PDDocument> it=pd1.listIterator(); int i=1;
	 * List<String> filepaths=new ArrayList<String>(); while(it.hasNext()) { String
	 * x="D:/files/merge/split"+i+".pdf"; File f=new File(x); PDDocument pd2
	 * =it.next(); pd2.save(f); i++; filepaths.add(x); } pd.close();
	 * 
	 * zipFiles(filepaths,res); return "index1"; }
	 */
	
	@RequestMapping(value="/split")
	public String split()
	{
		return "split";
	}
	
	@RequestMapping(value="/splitPdf", produces="application/zip",method=RequestMethod.POST)
	public String splitPdf(HttpServletResponse res,HttpServletRequest req,UserFile user ) throws IOException
	{
		String filepath=user.getUserfileString();
		splitter(filepath,req, res);
		return "download";
	}
public void splitter(String filepath, HttpServletRequest req,HttpServletResponse res) throws IOException
{
	 File file=new File(filepath);
	PDDocument pd=PDDocument.load(file);
	Splitter sp=new Splitter();
		List<PDDocument> pd1=sp.split(pd);
		Iterator<PDDocument> it=pd1.listIterator();
		int i=1;
		List<String> filepaths=new ArrayList<String>();
		while(it.hasNext())
		{
			String x="D:/files/merge/split"+i+".pdf";
			File f=new File(x);
			PDDocument pd2 =it.next();
			pd2.save(f);
			i++;
			filepaths.add(x);
		}
		pd.close();
		
		zipFiles(filepaths,res,"spliterzip");
		
}
	
	
	
	private void zipFiles(List<String> filepaths, HttpServletResponse res,String zipFormateName) throws IOException {
		String zipFileName="D:/"+zipFormateName+".zip";
		FileOutputStream fos =new FileOutputStream(zipFileName);
		ZipOutputStream zos=new ZipOutputStream(fos);
		for(String s:filepaths)
		{
			zos.putNextEntry(new ZipEntry(new File(s).getName()));
			byte[] bytes=Files.readAllBytes(Paths.get(s));
			zos.write(bytes);
			zos.closeEntry();
		}
		zos.close();
		File f=new File(zipFileName);
		res.setContentType("application/zip");
		res.setHeader("Content-Disposition", "attachement;filename=\""+f.getName()+"\"");
		res.setContentLength((int)f.length());
		InputStream is =new FileInputStream(f);
		ServletOutputStream out=res.getOutputStream();
		IOUtils.copy(is,out);
		is.close();
		out.flush();
		out.close();
		
	}
	/*
	 * //22/06/2020 Here we use Password only for perform task on Locked pdf. we
	 * also remove these password code from it also
	 * 
	 * @RequestMapping(value="/extractData") public String
	 * extractData(HttpServletRequest req) throws IOException { String
	 * password=req.getParameter("password"); if(password==null) { File file = new
	 * File("D:/files/merge/planet.pdf"); PDDocument pd=null; try {
	 * pd=PDDocument.load(file); }
	 * catch(org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException e) {
	 * req.setAttribute("filepath", "D:/files/merge/planet.pdf"); return
	 * "requestPassword"; } PDFTextStripper pdf=new PDFTextStripper(); String
	 * s=pdf.getText(pd); req.setAttribute("data", s); System.out.println(s); return
	 * "extractedData"; } else { File file = new File(req.getParameter("filePath"));
	 * PDDocument pd=null; pd=PDDocument.load(file,password); PDFTextStripper
	 * pdf=new PDFTextStripper(); String s=pdf.getText(pd); req.setAttribute("data",
	 * s); System.out.println(s); return "extractedData"; } }
	 */
		
	
	@RequestMapping(value="/extractData")
	public String extractData()
	{
		return "extractData";
	}
	@RequestMapping(value="/extractPdfData",method=RequestMethod.POST)
	public String extractPdfData(HttpServletRequest req,UserFile user ) throws SQLException, IOException
	{
		ArrayList<String> filePath=uploadFileOnServer(user);
		extract(filePath,req);
		System.out.println("extract controller called");
		return "extractedData";
	}
	

	public void extract(ArrayList<String> filePath, HttpServletRequest req) throws IOException {
		
		for(String s:filePath) 
		{
			File file=new File(s);
			PDDocument pd=PDDocument.load(file);
			PDFTextStripper pdf=new PDFTextStripper();
			String s1=pdf.getText(pd);
			req.setAttribute("data", s1);
			System.out.println(s1);
			//return "extractedData";
		}
		//return "extractedData";
	}
	
	
	
	//23/06/2020
	@RequestMapping(value="removePdfPage")
	public String removePdfPage()
	{
		return "removePdfPage";
	}

	/*
	 * public static File multipartToFile(MultipartFile multipart, String fileName)
	 * throws IllegalStateException, IOException { File convFile = new
	 * File(System.getProperty("java.io.tmpdir")+"/"+fileName);
	 * multipart.transferTo(convFile); return convFile; }
	 */
	public File convert(MultipartFile file) throws IOException
	{    
	  File convFile = new File(file.getOriginalFilename());
	  convFile.createNewFile(); 
	  FileOutputStream fos = new FileOutputStream(convFile); 
	  fos.write(file.getBytes());
	  fos.close(); 
	  return convFile;
	}
	@RequestMapping(value="/removePage")
	public String removePage(UserFile user) throws IOException
	{
		
		System.out.println("test1");
		System.out.println(user.getUserfile().getOriginalFilename());
	//	convert(user.getUserfile());
		System.out.println("test2");
		File file=convert(user.getUserfile());
		PDDocument pd=PDDocument.load(file);
		int totalpage=pd.getNumberOfPages();
		System.out.println(totalpage);
		int start=user.getstart();
		int end=user.getend();
		for (int i = start; i <=end; i++) {
			pd.removePage(start);
		}
		
		pd.save(user.getUserfile().getOriginalFilename());
		pd.close();
		return "download";	
	}
	
	
	
	@RequestMapping(value="/PdfToImage")
	public String PdfToImage()
	{
		return "PdfToImage";
	}
	//24/06/2020
	@RequestMapping(value="/pdftoImage")
	public String pdftoImage(UserFile user,HttpServletResponse res) throws IOException
	{
		
		File file=new File(user.getUserfileString());
		PDDocument pd=PDDocument.load(file);
		int totalpage=pd.getNumberOfPages();
		PDFRenderer re=new PDFRenderer(pd);
		List<String> filepaths=new ArrayList<String>();
		int i=0;
		while(i<totalpage)
		{
		BufferedImage img=re.renderImage(i);
		String x="D:/files/merge/splitNEW"+i+".jpg";
		File files=new File(x);
		ImageIO.write(img, "JPEG", files);
		i++;
		filepaths.add(x);
		}
		pd.close();
		zipFiles(filepaths, res,"pdfToimagezip");
		return "download";
	}
	
	//24/06/2020
	@RequestMapping(value="/protectPDF")
	public String protectPDF()
	{
		return"protectPDF";
	}
	@RequestMapping(value="/protect")
	public String protect(UserFile user,userProtection userpro) throws IOException{
		File file=new File(user.getUserfileString());
		PDDocument pd=PDDocument.load(file);
		AccessPermission ap=new AccessPermission();
		StandardProtectionPolicy policy=new StandardProtectionPolicy(userpro.getOwnerPassword(), userpro.getUserPassword(), ap);
		policy.setPermissions(ap);
		policy.setEncryptionKeyLength(256);
		pd.protect(policy);
		pd.save(user.getUserfileString());
		pd.close();
		return "index1";
	}
	
	
	@RequestMapping(value="unlockLockedPDF")
	public String unlockLockedPDF()
	{
		return "unlockLockedPDF";
	}
	//25/06/2020
	@RequestMapping(value="unlock")
	public String unlock(UserFile user,userProtection userpro)throws IOException
	{
		File file=new File(user.getUserfileString());
		PDDocument pd=PDDocument.load(file,userpro.getUserPassword());
		pd.setAllSecurityToBeRemoved(true);
		pd.save(user.getUserfileString());
		pd.close();
		return "index1";
	}
	@RequestMapping("sendemail")
	public String email()throws AddressException, MessagingException{

		Properties p= new Properties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.EnableSSL.enable", "true");
		p.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.socketFactory.port", "465");
		Session session=Session.getInstance(p, new SimpleAuthenticator("ramsahu0@rediffmail.com","9929216247"));
		Message msg=new MimeMessage(session);
		msg.setFrom(new InternetAddress("ramsahu0@rediffmail.com"));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress("abhisheksahu.2cse22@jecrc.ac.in"));
		msg.setSubject("email sending application");
		msg.setContent("Hello Abhishek Wat are you Doing", "text/html");	
		Transport.send(msg);
		return  "index1";

	}
	@RequestMapping(value="/login")
	public String login(User user,HttpServletRequest req,HttpSession session)
	{		
		System.out.println(session);
		String email="abhi@gmail.com";
		String pwd="1234";
		
		if(email.equals("abhi@gmail.com")&& pwd.equals("1234"))
		{
			session.setAttribute("id", "10");
			session.setAttribute("email", "abhi@gmail.com");
			return "index1";
		}
		return "login";
	}
	@RequestMapping(value="/index1")
	public String index1(HttpSession session)
	{
		String id=(String) session.getAttribute("id");
		System.out.println("index1 called");
		System.out.println();
		if(id==null)
			return "login";
		else
			return "index1";
		
	}
}