package com.jsh.exam.exam2.repository;

import com.jsh.exam.exam2.dto.Member;
import com.jtj.mysqlutil.MysqlUtil;
import com.jtj.mysqlutil.SecSql;

public class MemberRepository {

	public Member getMemberByLoginId(String loginId) {
		SecSql sql = new SecSql();
		sql.append("SELECT M.*");
		sql.append("FROM member AS M");
		sql.append("WHERE M.loginId = ?", loginId);
		
		return MysqlUtil.selectRow(sql, Member.class);
	}

}
