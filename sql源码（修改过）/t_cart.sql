CREATE TABLE t_cart (
	cid INT AUTO_INCREMENT COMMENT '���ﳵ����id',
	uid INT NOT NULL COMMENT '�û�id',
	pid INT NOT NULL COMMENT '��Ʒid',
	num INT COMMENT '��Ʒ����',
	created_time DATETIME COMMENT '����ʱ��',
	modified_time DATETIME COMMENT '�޸�ʱ��',
	PRIMARY KEY (cid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;