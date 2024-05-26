-- Alterando a tabela TBL_ALERTS para adicionar ID como chave primária
ALTER TABLE TBL_ALERTS ADD CONSTRAINT pk_tbl_alerts PRIMARY KEY (ID);

-- Alterando a tabela TBL_LOCATIONS para adicionar ID como chave primária
ALTER TABLE TBL_LOCATIONS ADD CONSTRAINT pk_tbl_locations PRIMARY KEY (ID);

-- Alterando a tabela TBL_USERS para adicionar ID como chave primária
ALTER TABLE TBL_USERS ADD CONSTRAINT pk_tbl_users PRIMARY KEY (ID);
