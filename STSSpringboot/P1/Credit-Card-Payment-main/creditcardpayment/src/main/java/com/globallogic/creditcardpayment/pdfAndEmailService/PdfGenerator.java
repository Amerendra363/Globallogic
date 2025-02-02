package com.globallogic.creditcardpayment.pdfAndEmailService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.creditcardpayment.entity.Account;
import com.globallogic.creditcardpayment.entity.CreditCard;
import com.globallogic.creditcardpayment.entity.Customer;
import com.globallogic.creditcardpayment.entity.Statement;
import com.globallogic.creditcardpayment.entity.Transaction;
import com.globallogic.creditcardpayment.repositories.AccountRepo;
import com.globallogic.creditcardpayment.repositories.CreditCardRepo;
import com.globallogic.creditcardpayment.repositories.CustomerRepo;
import com.globallogic.creditcardpayment.repositories.StatementRepo;
import com.globallogic.creditcardpayment.repositories.TransactionRepo;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PdfGenerator {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	AccountRepo accountRepo;

	@Autowired
	StatementRepo statementRepo;

	@Autowired
	TransactionRepo transactionRepo;

	@Autowired
	CreditCardRepo creditCardRepo;

	private PdfPTable table;

	private PdfPCell cell1, cell2, cell3, cell4, cell5, cell6;

	private float[] columnWidths;

	// TRANSACTIONS DONE BY CUSTOMER(POST METHOD)
	public String transactionForCustomer(long transId, double updateBalance) {

		Transaction tran = transactionRepo.findById(transId).get();
		Customer customer = customerRepo.findById(tran.getCustomer().getId()).get();
		Account account = accountRepo.findById(customer.getAccount().getAccountid()).get();

		String path = "";

		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("C:\\Users\\gaurav.k.singh\\Desktop\\ProjectStatement/Transaction" + transId
							+ "ForCustomer" + customer.getId() + ".pdf"));
			path = "C:\\Users\\gaurav.k.singh\\Desktop\\ProjectStatement/Transaction" + transId + "ForCustomer"
					+ customer.getId() + ".pdf";
			document.open();
			document.add(new Paragraph("                    CUSTOMER ID " + customer.getId()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" NAME : " + customer.getName()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" EMAIL : " + customer.getEmail()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" PHONE NO : " + customer.getPhoneNo()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" ACCOUNT NO : " + account.getAccountName()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" BALANCE : " + updateBalance));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(
					"                         TRANSACTION DETAILS                                              "));
			document.add(new Paragraph(" TRANSACTION ID : " + transId));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" TRANSACTION DATE : " + tran.getTranDate()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" DESCRIPTION : " + tran.getDescription()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" CARD NUMBER : " + tran.getCardNumber()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" AMOUNT : " + tran.getAmount()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" PAYMENT METHOD : " + tran.getPaymentMethod()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" STATUS : " + tran.getStatus()));
			document.add(new Paragraph(" "));

			document.close();
			writer.close();

		}

		catch (

		DocumentException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException exx) {
			exx.printStackTrace();
		}
		return path;

	}

	// ALL TRANSACTIONS FOR CUSTOMER ID (GET METHOD)
	public String showAllTransactionsForCustomerIdPdf(List<Transaction> listTransaction, long customerId) {

		Customer customer = customerRepo.findById(customerId).get();
		Account account = accountRepo.findById(customer.getAccount().getAccountid()).get();
		CreditCard cc = creditCardRepo.findById(customer.getId()).get();
		String path = "";

		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(
							"C:\\Users\\gaurav.k.singh\\Desktop\\ProjectStatement/TransactionStatementForCustomerId"
									+ customerId + ".pdf"));
			path = "C:\\Users\\gaurav.k.singh\\Desktop\\ProjectStatement/TransactionStatementForCustomerId" + customerId
					+ ".pdf";
			document.open();
			document.add(new Paragraph("                       ALL TRANSACTIONS FOR CUSTOMER ID " + customerId));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" NAME : " + customer.getName()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" EMAIL : " + customer.getEmail()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" PHONE NO : " + customer.getPhoneNo()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" ACCOUNT NO : " + account.getAccountName()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" CARD NUMBER : " + cc.getCardNumber()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" BALANCE : " + account.getBalance()));
			document.add(new Paragraph(" "));

			table = new PdfPTable(6); // 6 columns.
			table.setWidthPercentage(100); // Width 100%
			table.setSpacingBefore(10f); // Space before table
			table.setSpacingAfter(10f); // Space after table

			// Set Column widths
			columnWidths = new float[] { 2f, 2f, 1f, 2f, 2f, 1f };
			table.setWidths(columnWidths);

			cell1 = new PdfPCell(new Paragraph("TRANSACTION ID"));
			cell1.setBorderColor(BaseColor.BLUE);
			cell1.setPaddingLeft(10);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell2 = new PdfPCell(new Paragraph("TRANSACTION DATE"));
			cell2.setBorderColor(BaseColor.GREEN);
			cell2.setPaddingLeft(10);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell3 = new PdfPCell(new Paragraph("AMOUNT"));
			cell3.setBorderColor(BaseColor.RED);
			cell3.setPaddingLeft(10);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell4 = new PdfPCell(new Paragraph("DESCRIPTION"));
			cell4.setBorderColor(BaseColor.RED);
			cell4.setPaddingLeft(10);
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell5 = new PdfPCell(new Paragraph("PAYMENT_METHOD"));
			cell5.setBorderColor(BaseColor.RED);
			cell5.setPaddingLeft(10);
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell6 = new PdfPCell(new Paragraph("STATUS"));
			cell6.setBorderColor(BaseColor.RED);
			cell6.setPaddingLeft(10);
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

			// To avoid having the cell border and the content overlap, if you are having
			// thick cell borders
			// cell1.setUserBorderPadding(true);
			// cell2.setUserBorderPadding(true);
			// cell3.setUserBorderPadding(true);

			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			table.addCell(cell5);
			table.addCell(cell6);

			document.add(table);

			for (Transaction st : listTransaction) {
				table = new PdfPTable(6); // 4 columns.
				table.setWidthPercentage(100); // Width 100%
				table.setSpacingBefore(10f); // Space before table
				table.setSpacingAfter(10f); // Space after table

				// Set Column widths
				table.setWidths(columnWidths);

				PdfPCell cell1 = new PdfPCell(new Paragraph(st.getTransid() + " "));
				cell1.setBorderColor(BaseColor.BLUE);
				cell1.setPaddingLeft(10);
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell2 = new PdfPCell(new Paragraph(st.getTranDate() + ""));
				cell2.setBorderColor(BaseColor.GREEN);
				cell2.setPaddingLeft(10);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell3 = new PdfPCell(new Paragraph(st.getAmount() + " "));
				cell3.setBorderColor(BaseColor.RED);
				cell3.setPaddingLeft(10);
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell4 = new PdfPCell(new Paragraph(st.getDescription()));
				cell4.setBorderColor(BaseColor.RED);
				cell4.setPaddingLeft(10);
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell5 = new PdfPCell(new Paragraph(st.getPaymentMethod()));
				cell5.setBorderColor(BaseColor.RED);
				cell5.setPaddingLeft(10);
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell6 = new PdfPCell(new Paragraph(st.getStatus()));
				cell6.setBorderColor(BaseColor.RED);
				cell6.setPaddingLeft(10);
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

				// To avoid having the cell border and the content overlap, if you are having
				// thick cell borders
				// cell1.setUserBorderPadding(true);
				// cell2.setUserBorderPadding(true);
				// cell3.setUserBorderPadding(true);

				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
				table.addCell(cell5);
				table.addCell(cell6);

				document.add(table);
			}

			document.close();
			writer.close();
		} catch (DocumentException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException exx) {
			exx.printStackTrace();
		}
		return path;
	}

	// SHOW STATEMENT FOR CUSTOMER ID AND MONTH
	public String showAllTransactionsAndStatementForCustomerIdAndBillingDatePdf(List<Transaction> listTransaction,
			long customerId, LocalDate billingDate, long statementId, double dueAmount) {

		Customer customer = customerRepo.findById(customerId).get();
		Account account = accountRepo.findById(customer.getAccount().getAccountid()).get();
		CreditCard cc = creditCardRepo.findById(customer.getId()).get();
		String path = "";

		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(
							"C:\\Users\\gaurav.k.singh\\Desktop\\ProjectStatement/StatementForCustomerIdAndMonth"
									+ customerId + ".pdf"));
			path = "C:\\Users\\gaurav.k.singh\\Desktop\\ProjectStatement/StatementForCustomerIdAndMonth" + customerId
					+ ".pdf";
			document.open();
			document.add(new Paragraph("                        STATEMENT FOR CUSTOMER ID " + customerId
					+ " And For Month " + billingDate.getMonth()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" NAME : " + customer.getName()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" EMAIL : " + customer.getEmail()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" PHONE NO : " + customer.getPhoneNo()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" ACCOUNT NO : " + account.getAccountName()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" CARD NUMBER : " + cc.getCardNumber()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" BALANCE : " + account.getBalance()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));

			Statement statement = statementRepo.findByStatementid(statementId);
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" STATEMENT ID : " + statement.getStatementid()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" BILLING DATE : " + statement.getBillingDate()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" DUE AMOUNT : " + dueAmount));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" DUE DATE : " + statement.getDueDate()));

			table = new PdfPTable(6); // 6 columns.
			table.setWidthPercentage(100); // Width 100%
			table.setSpacingBefore(10f); // Space before table
			table.setSpacingAfter(10f); // Space after table

			// Set Column widths
			columnWidths = new float[] { 2f, 2f, 1f, 2f, 2f, 1f };
			table.setWidths(columnWidths);

			cell1 = new PdfPCell(new Paragraph("TRANSACTION ID"));
			cell1.setBorderColor(BaseColor.BLUE);
			cell1.setPaddingLeft(10);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell2 = new PdfPCell(new Paragraph("TRANSACTION DATE"));
			cell2.setBorderColor(BaseColor.GREEN);
			cell2.setPaddingLeft(10);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell3 = new PdfPCell(new Paragraph("AMOUNT"));
			cell3.setBorderColor(BaseColor.RED);
			cell3.setPaddingLeft(10);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell4 = new PdfPCell(new Paragraph("DESCRIPTION"));
			cell4.setBorderColor(BaseColor.RED);
			cell4.setPaddingLeft(10);
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell5 = new PdfPCell(new Paragraph("PAYMENT_METHOD"));
			cell5.setBorderColor(BaseColor.RED);
			cell5.setPaddingLeft(10);
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell6 = new PdfPCell(new Paragraph("STATUS"));
			cell6.setBorderColor(BaseColor.RED);
			cell6.setPaddingLeft(10);
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

			// To avoid having the cell border and the content overlap, if you are having
			// thick cell borders
			// cell1.setUserBorderPadding(true);
			// cell2.setUserBorderPadding(true);
			// cell3.setUserBorderPadding(true);

			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			table.addCell(cell5);
			table.addCell(cell6);

			document.add(table);

			for (Transaction st : listTransaction) {
				table = new PdfPTable(6); // 4 columns.
				table.setWidthPercentage(100); // Width 100%
				table.setSpacingBefore(10f); // Space before table
				table.setSpacingAfter(10f); // Space after table

				// Set Column widths
				table.setWidths(columnWidths);

				PdfPCell cell1 = new PdfPCell(new Paragraph(st.getTransid() + " "));
				cell1.setBorderColor(BaseColor.BLUE);
				cell1.setPaddingLeft(10);
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell2 = new PdfPCell(new Paragraph(st.getTranDate() + ""));
				cell2.setBorderColor(BaseColor.GREEN);
				cell2.setPaddingLeft(10);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell3 = new PdfPCell(new Paragraph(st.getAmount() + " "));
				cell3.setBorderColor(BaseColor.RED);
				cell3.setPaddingLeft(10);
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell4 = new PdfPCell(new Paragraph(st.getDescription()));
				cell4.setBorderColor(BaseColor.RED);
				cell4.setPaddingLeft(10);
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell5 = new PdfPCell(new Paragraph(st.getPaymentMethod()));
				cell5.setBorderColor(BaseColor.RED);
				cell5.setPaddingLeft(10);
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell6 = new PdfPCell(new Paragraph(st.getStatus()));
				cell6.setBorderColor(BaseColor.RED);
				cell6.setPaddingLeft(10);
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

				// To avoid having the cell border and the content overlap, if you are having
				// thick cell borders
				// cell1.setUserBorderPadding(true);
				// cell2.setUserBorderPadding(true);
				// cell3.setUserBorderPadding(true);

				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
				table.addCell(cell5);
				table.addCell(cell6);

				document.add(table);

			}
			document.close();
			writer.close();
		} catch (DocumentException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException exx) {
			exx.printStackTrace();
		}
		return path;
	}

	// SHOW BILLED STATEMENT FOR CUSTOMER ID AND MONTH
	public String showBilledStatementWithAllTransactionsForCustomerIdAndBillingDatePdf(
			List<Transaction> listTransaction, long customerId, LocalDate billingDate, long statementId) {

		Customer customer = customerRepo.findById(customerId).get();
		Account account = accountRepo.findById(customer.getAccount().getAccountid()).get();
		CreditCard cc = creditCardRepo.findById(customer.getId()).get();
		String path = "";

		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(
							"C:\\Users\\gaurav.k.singh\\Desktop\\ProjectStatement/BilledStatementForCustomerIdAndMonth"
									+ customerId + ".pdf"));
			path = "C:\\Users\\gaurav.k.singh\\Desktop\\ProjectStatement/BilledStatementForCustomerIdAndMonth"
					+ customerId + ".pdf";
			document.open();
			document.add(new Paragraph("                       BILLED STATEMENT FOR CUSTOMER ID " + customerId
					+ " And For Month " + billingDate.getMonth()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" NAME : " + customer.getName()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" EMAIL : " + customer.getEmail()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" PHONE NO : " + customer.getPhoneNo()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" ACCOUNT NO : " + account.getAccountName()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" CARD NUMBER : " + cc.getCardNumber()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" BALANCE : " + account.getBalance()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));

			Statement statement = statementRepo.findByStatementid(statementId);
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" STATEMENT ID : " + statement.getStatementid()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" BILLING DATE : " + statement.getBillingDate()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" DUE AMOUNT : " + statement.getDueAmount()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" DUE DATE : " + statement.getDueDate()));

			table = new PdfPTable(6); // 6 columns.
			table.setWidthPercentage(100); // Width 100%
			table.setSpacingBefore(10f); // Space before table
			table.setSpacingAfter(10f); // Space after table

			// Set Column widths
			columnWidths = new float[] { 2f, 2f, 1f, 2f, 2f, 1f };
			table.setWidths(columnWidths);

			cell1 = new PdfPCell(new Paragraph("TRANSACTION ID"));
			cell1.setBorderColor(BaseColor.BLUE);
			cell1.setPaddingLeft(10);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell2 = new PdfPCell(new Paragraph("TRANSACTION DATE"));
			cell2.setBorderColor(BaseColor.GREEN);
			cell2.setPaddingLeft(10);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell3 = new PdfPCell(new Paragraph("AMOUNT"));
			cell3.setBorderColor(BaseColor.RED);
			cell3.setPaddingLeft(10);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell4 = new PdfPCell(new Paragraph("DESCRIPTION"));
			cell4.setBorderColor(BaseColor.RED);
			cell4.setPaddingLeft(10);
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell5 = new PdfPCell(new Paragraph("PAYMENT_METHOD"));
			cell5.setBorderColor(BaseColor.RED);
			cell5.setPaddingLeft(10);
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell6 = new PdfPCell(new Paragraph("STATUS"));
			cell6.setBorderColor(BaseColor.RED);
			cell6.setPaddingLeft(10);
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

			// To avoid having the cell border and the content overlap, if you are having
			// thick cell borders
			// cell1.setUserBorderPadding(true);
			// cell2.setUserBorderPadding(true);
			// cell3.setUserBorderPadding(true);

			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			table.addCell(cell5);
			table.addCell(cell6);

			document.add(table);

			for (Transaction st : listTransaction) {
				table = new PdfPTable(6); // 4 columns.
				table.setWidthPercentage(100); // Width 100%
				table.setSpacingBefore(10f); // Space before table
				table.setSpacingAfter(10f); // Space after table

				// Set Column widths
				table.setWidths(columnWidths);

				PdfPCell cell1 = new PdfPCell(new Paragraph(st.getTransid() + " "));
				cell1.setBorderColor(BaseColor.BLUE);
				cell1.setPaddingLeft(10);
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell2 = new PdfPCell(new Paragraph(st.getTranDate() + ""));
				cell2.setBorderColor(BaseColor.GREEN);
				cell2.setPaddingLeft(10);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell3 = new PdfPCell(new Paragraph(st.getAmount() + " "));
				cell3.setBorderColor(BaseColor.RED);
				cell3.setPaddingLeft(10);
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell4 = new PdfPCell(new Paragraph(st.getDescription()));
				cell4.setBorderColor(BaseColor.RED);
				cell4.setPaddingLeft(10);
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell5 = new PdfPCell(new Paragraph(st.getPaymentMethod()));
				cell5.setBorderColor(BaseColor.RED);
				cell5.setPaddingLeft(10);
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell6 = new PdfPCell(new Paragraph(st.getStatus()));
				cell6.setBorderColor(BaseColor.RED);
				cell6.setPaddingLeft(10);
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

				// To avoid having the cell border and the content overlap, if you are having
				// thick cell borders
				// cell1.setUserBorderPadding(true);
				// cell2.setUserBorderPadding(true);
				// cell3.setUserBorderPadding(true);

				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
				table.addCell(cell5);
				table.addCell(cell6);

				document.add(table);

			}
			document.close();
			writer.close();
		} catch (DocumentException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException exx) {
			exx.printStackTrace();
		}
		return path;
	}

	// SHOW UNBILLED STATEMENT FOR CUSTOMER ID AND MONTH
	public String showUnBilledStatementWithAllTransactionsForCustomerIdAndBillingDatePdf(
			List<Transaction> listTransaction, long customerId, LocalDate currentDate, double sum) {

		Customer customer = customerRepo.findById(customerId).get();
		Account account = accountRepo.findById(customer.getAccount().getAccountid()).get();
		CreditCard cc = creditCardRepo.findById(customer.getId()).get();
		String path = "";

		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
					"C:\\Users\\gaurav.k.singh\\Desktop\\ProjectStatement/UnBilledStatementForCustomerIdAndMonth"
							+ customerId + ".pdf"));
			path = "C:\\Users\\gaurav.k.singh\\Desktop\\ProjectStatement/UnBilledStatementForCustomerIdAndMonth"
					+ customerId + ".pdf";
			document.open();
			document.add(new Paragraph("                       BILLED STATEMENT FOR CUSTOMER ID " + customerId
					+ " And For Month " + currentDate.plusDays(30).getMonth()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" NAME : " + customer.getName()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" EMAIL : " + customer.getEmail()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" PHONE NO : " + customer.getPhoneNo()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" ACCOUNT NO : " + account.getAccountName()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" CARD NUMBER : " + cc.getCardNumber()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" BALANCE : " + account.getBalance()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("UNBILLED STATEMENT DETAILS "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" TODAY'S DATE : " + currentDate));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" DUE AMOUNT : " + sum));
			document.add(new Paragraph(" "));

			table = new PdfPTable(6); // 6 columns.
			table.setWidthPercentage(100); // Width 100%
			table.setSpacingBefore(10f); // Space before table
			table.setSpacingAfter(10f); // Space after table

			// Set Column widths
			columnWidths = new float[] { 2f, 2f, 1f, 2f, 2f, 1f };
			table.setWidths(columnWidths);

			cell1 = new PdfPCell(new Paragraph("TRANSACTION ID"));
			cell1.setBorderColor(BaseColor.BLUE);
			cell1.setPaddingLeft(10);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell2 = new PdfPCell(new Paragraph("TRANSACTION DATE"));
			cell2.setBorderColor(BaseColor.GREEN);
			cell2.setPaddingLeft(10);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell3 = new PdfPCell(new Paragraph("AMOUNT"));
			cell3.setBorderColor(BaseColor.RED);
			cell3.setPaddingLeft(10);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell4 = new PdfPCell(new Paragraph("DESCRIPTION"));
			cell4.setBorderColor(BaseColor.RED);
			cell4.setPaddingLeft(10);
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell5 = new PdfPCell(new Paragraph("PAYMENT_METHOD"));
			cell5.setBorderColor(BaseColor.RED);
			cell5.setPaddingLeft(10);
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell6 = new PdfPCell(new Paragraph("STATUS"));
			cell6.setBorderColor(BaseColor.RED);
			cell6.setPaddingLeft(10);
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

			// To avoid having the cell border and the content overlap, if you are having
			// thick cell borders
			// cell1.setUserBorderPadding(true);
			// cell2.setUserBorderPadding(true);
			// cell3.setUserBorderPadding(true);

			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			table.addCell(cell5);
			table.addCell(cell6);

			document.add(table);

			for (Transaction st : listTransaction) {
				table = new PdfPTable(6); // 4 columns.
				table.setWidthPercentage(100); // Width 100%
				table.setSpacingBefore(10f); // Space before table
				table.setSpacingAfter(10f); // Space after table

				// Set Column widths
				table.setWidths(columnWidths);

				PdfPCell cell1 = new PdfPCell(new Paragraph(st.getTransid() + " "));
				cell1.setBorderColor(BaseColor.BLUE);
				cell1.setPaddingLeft(10);
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell2 = new PdfPCell(new Paragraph(st.getTranDate() + ""));
				cell2.setBorderColor(BaseColor.GREEN);
				cell2.setPaddingLeft(10);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell3 = new PdfPCell(new Paragraph(st.getAmount() + " "));
				cell3.setBorderColor(BaseColor.RED);
				cell3.setPaddingLeft(10);
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell4 = new PdfPCell(new Paragraph(st.getDescription()));
				cell4.setBorderColor(BaseColor.RED);
				cell4.setPaddingLeft(10);
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell5 = new PdfPCell(new Paragraph(st.getPaymentMethod()));
				cell5.setBorderColor(BaseColor.RED);
				cell5.setPaddingLeft(10);
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell6 = new PdfPCell(new Paragraph(st.getStatus()));
				cell6.setBorderColor(BaseColor.RED);
				cell6.setPaddingLeft(10);
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

				// To avoid having the cell border and the content overlap, if you are having
				// thick cell borders
				// cell1.setUserBorderPadding(true);
				// cell2.setUserBorderPadding(true);
				// cell3.setUserBorderPadding(true);

				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
				table.addCell(cell5);
				table.addCell(cell6);

				document.add(table);

			}
			document.close();
			writer.close();
		} catch (DocumentException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException exx) {
			exx.printStackTrace();
		}
		return path;
	}

	// SHOW UNBILLED STATEMENT FOR CUSTOMER ID AND MONTH
	public String showUnBilledStatementWithAllTransactionsForCustomerIdAndBillingDatePdf1(
			List<Transaction> listTransaction, long customerId, LocalDate currentDate, double sum) {

		Customer customer = customerRepo.findById(customerId).get();
		Account account = accountRepo.findById(customer.getAccount().getAccountid()).get();
		CreditCard cc = creditCardRepo.findById(customer.getId()).get();
		String path = "";

		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
					"C:\\Users\\gaurav.k.singh\\Desktop\\ProjectStatement/UnBilledStatementForCustomerIdAndMonth"
							+ customerId + ".pdf"));
			path = "C:\\Users\\gaurav.k.singh\\Desktop\\ProjectStatement/UnBilledStatementForCustomerIdAndMonth"
					+ customerId + ".pdf";
			document.open();
			document.add(new Paragraph("                       BILLED STATEMENT FOR CUSTOMER ID " + customerId
					+ " And For Month " + currentDate.getMonth()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" NAME : " + customer.getName()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" EMAIL : " + customer.getEmail()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" PHONE NO : " + customer.getPhoneNo()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" ACCOUNT NO : " + account.getAccountName()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" CARD NUMBER : " + cc.getCardNumber()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" BALANCE : " + account.getBalance()));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("UNBILLED STATEMENT DETAILS "));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" TODAY'S DATE : " + currentDate));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" DUE AMOUNT : " + sum));
			document.add(new Paragraph(" "));

			table = new PdfPTable(6); // 6 columns.
			table.setWidthPercentage(100); // Width 100%
			table.setSpacingBefore(10f); // Space before table
			table.setSpacingAfter(10f); // Space after table

			// Set Column widths
			columnWidths = new float[] { 2f, 2f, 1f, 2f, 2f, 1f };
			table.setWidths(columnWidths);

			cell1 = new PdfPCell(new Paragraph("TRANSACTION ID"));
			cell1.setBorderColor(BaseColor.BLUE);
			cell1.setPaddingLeft(10);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell2 = new PdfPCell(new Paragraph("TRANSACTION DATE"));
			cell2.setBorderColor(BaseColor.GREEN);
			cell2.setPaddingLeft(10);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell3 = new PdfPCell(new Paragraph("AMOUNT"));
			cell3.setBorderColor(BaseColor.RED);
			cell3.setPaddingLeft(10);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell4 = new PdfPCell(new Paragraph("DESCRIPTION"));
			cell4.setBorderColor(BaseColor.RED);
			cell4.setPaddingLeft(10);
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell5 = new PdfPCell(new Paragraph("PAYMENT_METHOD"));
			cell5.setBorderColor(BaseColor.RED);
			cell5.setPaddingLeft(10);
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell6 = new PdfPCell(new Paragraph("STATUS"));
			cell6.setBorderColor(BaseColor.RED);
			cell6.setPaddingLeft(10);
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

			// To avoid having the cell border and the content overlap, if you are having
			// thick cell borders
			// cell1.setUserBorderPadding(true);
			// cell2.setUserBorderPadding(true);
			// cell3.setUserBorderPadding(true);

			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			table.addCell(cell5);
			table.addCell(cell6);

			document.add(table);

			for (Transaction st : listTransaction) {
				table = new PdfPTable(6); // 4 columns.
				table.setWidthPercentage(100); // Width 100%
				table.setSpacingBefore(10f); // Space before table
				table.setSpacingAfter(10f); // Space after table

				// Set Column widths
				table.setWidths(columnWidths);

				PdfPCell cell1 = new PdfPCell(new Paragraph(st.getTransid() + " "));
				cell1.setBorderColor(BaseColor.BLUE);
				cell1.setPaddingLeft(10);
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell2 = new PdfPCell(new Paragraph(st.getTranDate() + ""));
				cell2.setBorderColor(BaseColor.GREEN);
				cell2.setPaddingLeft(10);
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell3 = new PdfPCell(new Paragraph(st.getAmount() + " "));
				cell3.setBorderColor(BaseColor.RED);
				cell3.setPaddingLeft(10);
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell4 = new PdfPCell(new Paragraph(st.getDescription()));
				cell4.setBorderColor(BaseColor.RED);
				cell4.setPaddingLeft(10);
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell5 = new PdfPCell(new Paragraph(st.getPaymentMethod()));
				cell5.setBorderColor(BaseColor.RED);
				cell5.setPaddingLeft(10);
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

				PdfPCell cell6 = new PdfPCell(new Paragraph(st.getStatus()));
				cell6.setBorderColor(BaseColor.RED);
				cell6.setPaddingLeft(10);
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);

				// To avoid having the cell border and the content overlap, if you are having
				// thick cell borders
				// cell1.setUserBorderPadding(true);
				// cell2.setUserBorderPadding(true);
				// cell3.setUserBorderPadding(true);

				table.addCell(cell1);
				table.addCell(cell2);
				table.addCell(cell3);
				table.addCell(cell4);
				table.addCell(cell5);
				table.addCell(cell6);

				document.add(table);

			}
			document.close();
			writer.close();
		} catch (DocumentException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException exx) {
			exx.printStackTrace();
		}
		return path;
	}

}
