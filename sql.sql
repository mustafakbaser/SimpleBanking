CREATE TABLE `account` (
                           `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                           `owner` VARCHAR(255) NOT NULL,
                           `account_number` VARCHAR(255) NOT NULL,
                           `balance` DECIMAL(10,2) NOT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `uq_account_number` (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `deposit_transaction` (
                                       `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                       `amount` DECIMAL(10,2) NOT NULL,
                                       `approval_code` VARCHAR(255) DEFAULT NULL,
                                       `date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                       `type` VARCHAR(255) DEFAULT NULL,
                                       `account_id` INT UNSIGNED NOT NULL,
                                       PRIMARY KEY (`id`),
                                       KEY `fk_deposit_transaction_account_id` (`account_id`),
                                       CONSTRAINT `fk_deposit_transaction_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `phone_bill_payment_transaction` (
                                                  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                                  `phone_number` VARCHAR(20) NOT NULL,
                                                  `amount` DECIMAL(10,2) DEFAULT NULL,
                                                  `approval_code` VARCHAR(255) DEFAULT NULL,
                                                  `date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                                  `type` VARCHAR(255) DEFAULT NULL,
                                                  `account_id` INT UNSIGNED NOT NULL,
                                                  `payee` VARCHAR(255) DEFAULT NULL,
                                                  PRIMARY KEY (`id`),
                                                  KEY `fk_phone_bill_payment_transaction_account_id` (`account_id`),
                                                  CONSTRAINT `fk_phone_bill_payment_transaction_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `bill_payment_transaction` (
                                            `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                            `payee` VARCHAR(255) NOT NULL,
                                            `amount` DECIMAL(10,2) NOT NULL,
                                            `approval_code` VARCHAR(255) DEFAULT NULL,
                                            `date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                            `type` VARCHAR(255) DEFAULT NULL,
                                            `account_id` INT UNSIGNED NOT NULL,
                                            PRIMARY KEY (`id`),
                                            KEY `fk_bill_payment_transaction_account_id` (`account_id`),
                                            CONSTRAINT `fk_bill_payment_transaction_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
