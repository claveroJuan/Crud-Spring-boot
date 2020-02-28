//package com.springboot.auth;
//
//public class JwtConfig {
//	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
//	
//	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
//			"MIIEpAIBAAKCAQEAyrxLUMZ1jbZVcJlbFGkRpGWvJSYGfFp6WW3yoL+OC0T3vRPC\r\n" + 
//			"fLbepbUOTUz0QsCQlT9s2D2m2HFOO9emgyj0bChC2QKueQX4Yfblfe0mrOgzOcxf\r\n" + 
//			"5Oyx2FN+9EiDyZC4Djp/D5u0D+VV9hcxM7ykGcNdRxxY9Lz7Hc7+XaWXxgyiz29c\r\n" + 
//			"fC5HLhrNc/YwVySlgIYjvVlymbWUIrLu/dtpOxLuVF7NXV9C8C2365XcDCvWImgn\r\n" + 
//			"QO1NkkBuiROeM3q+rdk16iQJeLmaEDAzrnXqB5ZA5braD3rGrG8lsVptZGmnaWng\r\n" + 
//			"xXleqKATmgVQos0hfp1nP2DHIU52uhBCCV7OlQIDAQABAoIBAQDEuAC82FWotIwj\r\n" + 
//			"PitKmskrpB9XBJa2g3TE4hLUOAs0lC9voITPTwKr+AtwpoM9Ymzo5SpQiUIkM42e\r\n" + 
//			"M5q3Gj5R1J9Iw3lYpZpmNJRqpHsqvAU4yD8keyf2qM4/az21kF+ILuqr0oHeCsJm\r\n" + 
//			"kAqGET2KYi9YmQEYOWfRfNEFPXEQEecoSSOp2pMcrxNGBzlhz/EX9Ir/B10tSsMo\r\n" + 
//			"baggvEh2JJkiL7zqSQpq0Hn5Z0u6qfSI4+SghjDBmXfzKSCaoy8+ApE0lxbc27az\r\n" + 
//			"bXI/kY3GxMLlElV47WlS/Zv5D0RNWPV+Y6IOzvRYPbB8HwpVdGan3riTGtDsyevm\r\n" + 
//			"v4IvafQBAoGBAPdyqaBdS4VJiYmXxA14BtOt7ENXELVVdUa446cxxZOOaYBM6/1a\r\n" + 
//			"gPXwzb4VxNNid1i1Ews4+G1sIXRHQeO6ILCLVkzjY+k+ZSkmtyA86g+JyiCoZr8Z\r\n" + 
//			"diaCHpdb/WrDG9UFuNAPVqhxm9FTmMFqhMkcqqbmes0Ij4U9H6F0fSShAoGBANG+\r\n" + 
//			"B/9acMNH2PyJe4jUUocr0b2q9/OUBiNGo2Hj1cYDTlLqyEHAkNw7M2JuNPp8FFYP\r\n" + 
//			"jIM7N09azMiLsaMDbtHwMwtUEwIqFoczl8bnTkmhcDzMXQxToJY+k3uYZtfwggPk\r\n" + 
//			"QC8SPRuA++ovsGPaeT+hua6Hxo9/qZ7g9LatwnF1AoGAPJLSGVKdSRyOUaNYN9/Y\r\n" + 
//			"8/qQao+mpG0uD0j1WZlif1OOWfz6jAOarBntk4mqrABfrNRuvAGPNuIQcnF7HK8U\r\n" + 
//			"j4Mcdif37kH6647xpy+iMHmPhF0VAdTOynBx4qV/LKJkbso+ypfmo8dj2GM5cqeL\r\n" + 
//			"p9ufnsmu6AAfegNTeeeVNuECgYEAqQE+4Hu3sSMLrTH64N51QYYFk5dYBGWaLIKW\r\n" + 
//			"1CIJ92xiiF22z4SjNVJerUmwVsX0fQQ6bOQiRUcdC9vEX148xd2Ow+oTBwNy866W\r\n" + 
//			"9icb5ii3j8X8lBouo+H4ZPcAp6+clBYvwb4ojyj31FRpBYzddnCSdhfh32829la9\r\n" + 
//			"2RVaQKECgYAMzw9QBCWt1xTlIobUXY+o2SGzU1anlLrDrCno3kffb2eWaCq2/nbK\r\n" + 
//			"hLkqIK0Y8IhPb8TS7tQiHgJP1g6PbE9ZeabRSaEJVVkVcMeC/me6p3mCRPw2mD75\r\n" + 
//			"7qHb7If11af9u9s01CmxEW3Wp2P7CmkVLtuC4yKOjLAEuuEzyBcvhg==\r\n" + 
//			"-----END RSA PRIVATE KEY-----";
//	
//	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
//			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyrxLUMZ1jbZVcJlbFGkR\r\n" + 
//			"pGWvJSYGfFp6WW3yoL+OC0T3vRPCfLbepbUOTUz0QsCQlT9s2D2m2HFOO9emgyj0\r\n" + 
//			"bChC2QKueQX4Yfblfe0mrOgzOcxf5Oyx2FN+9EiDyZC4Djp/D5u0D+VV9hcxM7yk\r\n" + 
//			"GcNdRxxY9Lz7Hc7+XaWXxgyiz29cfC5HLhrNc/YwVySlgIYjvVlymbWUIrLu/dtp\r\n" + 
//			"OxLuVF7NXV9C8C2365XcDCvWImgnQO1NkkBuiROeM3q+rdk16iQJeLmaEDAzrnXq\r\n" + 
//			"B5ZA5braD3rGrG8lsVptZGmnaWngxXleqKATmgVQos0hfp1nP2DHIU52uhBCCV7O\r\n" + 
//			"lQIDAQAB\r\n" + 
//			"-----END PUBLIC KEY-----";
//
//}
