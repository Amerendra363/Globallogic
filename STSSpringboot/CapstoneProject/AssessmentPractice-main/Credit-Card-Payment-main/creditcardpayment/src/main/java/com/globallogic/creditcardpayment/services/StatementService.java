package com.globallogic.creditcardpayment.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globallogic.creditcardpayment.entity.Statement;
@Service
public interface StatementService {
	public List<Statement> getAllStatement();

	public void addStatement(Statement statement);

	public Statement updateStatement(Statement statement);

	public void removeStatement(long id);

	public Statement getStatement(long id);

}
