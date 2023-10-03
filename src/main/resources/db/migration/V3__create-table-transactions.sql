CREATE TABLE transactions(
   orderId TEXT PRIMARY KEY UNIQUE NOT NULL,
   typeTransaction TEXT NOT NULL,
   valueTransaction INT NOT NULL
);