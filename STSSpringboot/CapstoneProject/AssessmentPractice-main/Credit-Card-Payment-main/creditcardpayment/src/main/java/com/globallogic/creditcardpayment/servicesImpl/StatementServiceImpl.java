package com.globallogic.creditcardpayment.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.creditcardpayment.entity.Statement;
import com.globallogic.creditcardpayment.repositories.StatementRepo;
import com.globallogic.creditcardpayment.services.StatementService;
@Service
public class StatementServiceImpl implements StatementService {	
@Autowired
StatementRepo statementrepo;


		@Override
		public List<Statement> getAllStatement() {
		
			return statementrepo.findAll();
		}

		@Override
		public void addStatement(Statement statement) {
			
			statementrepo.save(statement);
		}

		@Override
		public Statement updateStatement(Statement statement) {
		
			return statementrepo.save(statement);
		}
		@Override
		public void removeStatement(long id) {
		
		
			statementrepo.deleteById(id);;
			
		}
		@Override
		public Statement getStatement(long id) {
			
			return statementrepo.findById(id).get();
			
		}

	
	
}
