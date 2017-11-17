create table tb_customer_account
	(id_customer number(8) not null,
	cpf_cnpj varchar2(18),
	nm_customer varchar2(40),
	is_active char(1),
	vl_total number(8,2),
	constraint pk_idcustomer primary key(id_customer),
	constraint uk_idcustomer unique (id_customer);