CREATE TABLE urubu(
   id TEXT PRIMARY KEY UNIQUE NOT NULL,
   username TEXT UNIQUE NOT NULL,
   typeTransaction TEXT NOT NULL,
   valueTransaction INT NOT NULL,
   orderId TEXT UNIQUE NOT NULL
);