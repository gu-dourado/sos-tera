-- Adicionando coluna ID_LOCATION na tabela TBL_ALERTS
ALTER TABLE TBL_ALERTS ADD ID_LOCATION INTEGER;

-- Adicionando chave estrangeira fk_alerts_id_location
ALTER TABLE TBL_ALERTS ADD CONSTRAINT fk_alerts_id_location
    FOREIGN KEY (ID_LOCATION) REFERENCES TBL_LOCATIONS(ID);

-- Adicionando coluna ID_ALERT na tabela TBL_USERS
ALTER TABLE TBL_USERS ADD ID_ALERT INTEGER;

-- Adicionando chave estrangeira fk_users_id_alert
ALTER TABLE TBL_USERS ADD CONSTRAINT fk_users_id_alert
    FOREIGN KEY (ID_ALERT) REFERENCES TBL_ALERTS(ID);
