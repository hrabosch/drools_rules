# Example POST Request

```
{
    "accountUid" : "000001",
    "symbol" : "APPL",
    "quantity" : 1000,
    "productTypes": ["EQUITY", "OPTIONS"]
}
```

AccountID ending with 1 has different rules, see OrderValidationService implementation.
