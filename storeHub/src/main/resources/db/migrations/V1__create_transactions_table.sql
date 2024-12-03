CREATE TABLE transactions (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              transaction_id VARCHAR(100) UNIQUE NOT NULL,
                              total_amount DECIMAL(10, 2) NOT NULL,
                              timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              synced BOOLEAN DEFAULT FALSE
);
