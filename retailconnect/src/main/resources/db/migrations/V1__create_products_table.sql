CREATE TABLE products (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          sku VARCHAR(100) UNIQUE NOT NULL,
                          price DECIMAL(10, 2) NOT NULL,
                          tax_rate DECIMAL(5, 2) NOT NULL
);
CREATE TABLE corporate_transactions (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        store_id VARCHAR(100) NOT NULL, -- ID of the store that sent the transaction
                                        transaction_id VARCHAR(100) UNIQUE NOT NULL, -- Unique ID of the transaction
                                        total_amount DECIMAL(10, 2) NOT NULL,
                                        timestamp TIMESTAMP NOT NULL, -- Time of transaction
                                        synced BOOLEAN DEFAULT TRUE
);
