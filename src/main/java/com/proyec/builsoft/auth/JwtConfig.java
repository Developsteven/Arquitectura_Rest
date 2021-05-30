package com.proyec.builsoft.auth;

public class JwtConfig {
	
	public static final String LLAVE_SECRETA = "generando.una.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEogIBAAKCAQEAn8Lwv/W0zI1j3KljsCyKuDnDi72D6jAlycnh5e8lkIvawDxy\r\n"
			+ "Td863gAwT7uLJTTKGrRy/UfzKQv5fcxk7j0pxWg4pB6aM0wXK5y3unR6EqRAVvZC\r\n"
			+ "xxhHjGdCUB+qXZ+2TKAz18TJse3HkJmhFDi43a/bDzlNHkKxYT0534wLSAXVN7Ag\r\n"
			+ "mFPp9VFw79l1rPBA8Y5RMpOPQIBF0U0KUSEHlVfpf+OaudmZ3SslbOqj6DutQ1V5\r\n"
			+ "o9c0SfEZp6AEmiWYDeS16OEwC18mOT1aI7RBc1rsOgi50TUrz/7PjDEOMxpVzauZ\r\n"
			+ "wNTfaOJ+XvVoGIC+0lNf9VZXFa4FNGG5Ns2YOQIDAQABAoIBACJiWWBnKG9x6tE+\r\n"
			+ "H7d2DrERtZVox3BqxmdErPrI2qPehckj+VHrPoczMTKn4Y2za+ANgEYk6x+ldR/v\r\n"
			+ "ErX3sfrLsI0aDQQHV2FKjHxzvyYt9a8Bt2OURSnhu3L1LbySuDCLtjy1HNfPnkjv\r\n"
			+ "16w7fQYxaAtBwOhHYFfWTpNfV7o7OBg6v7DPfQYOxnKxQ3kUgswoBTTYAkznLof2\r\n"
			+ "eGjJ/1cOXtgVww0OWpwjljBUDWFazJl3b/ZI5/MWOneIwtDVTBjSjAEUbRJeeUoJ\r\n"
			+ "/Fp77FZZJFBzJECiAdu3e1rd4HJGFdwlgLHIMP6lxIU1mcnURKeQCxKCCzizfFC9\r\n"
			+ "aeB7SdECgYEAyllRiO+rfTuVKNoGEFNLbyjS1gFGrIfIA023CSmTRxeV38jO9je5\r\n"
			+ "lHaxZCwx2Lnk45tWY7Pil0MU4wI0/VBwkJHQebgvcHx9lfj6KmTKgY9oPvoxicQN\r\n"
			+ "rX6F17zaiaU1SYmWrby7jPaKjbipB3dtnm9heO945zpoiNoq8ljgtc0CgYEAyh7y\r\n"
			+ "1vj8GOtAT4lH0pF0QN2bkVHEG5FTjtk73evjfP3vhcuwBNA3JlU2Nt0czZ+yt1tL\r\n"
			+ "q1BCeIvWy3olM1zMaDzsx/LnwjrWrg++XFStsiDLetGus4ydOI5lAI07oe+MS0JL\r\n"
			+ "5mJspqCcc6K4fp9nZ4k1sqIYNdGaXwAbLaG9AB0CgYAgNZeE9KGXjaRwnEPa1Wds\r\n"
			+ "ilMFPa7CR9rOq9A25SdMabSxqoVHLBeeSkZya5aDqROGJ3PY6wlmiocIm5FTwTop\r\n"
			+ "yQwmU+s5PJfBB6DKnsCdXvZ5D9pS06JZu4oSjT08K9APpJcXkLNJ/PSRGpPNXHVW\r\n"
			+ "guRBG91i8Skyn4e2i+85AQKBgCqj8NNNX9HZ/41IBvDzYrU0i1dTCq5OMHSYe7rL\r\n"
			+ "wwhhgiCV4iKB0sCxhWh5qVPv9wIbrpELs5o+1ifDMwns7+qlv8ZHBoHBa/z4sU5F\r\n"
			+ "RwenR4Y3qkWSyrBdyg0dvpDhOpW9/Mkzxnw4sgjrMUT1WBlNpxhyfe0MtSaJnTI5\r\n"
			+ "Rug5AoGABtTkCu4Gq6pTH91ZOSAIr7QOVsjEiur3IdM7x6QaWGHqy7IdIJoymMl4\r\n"
			+ "OP69jKGmdDQSY1UXkGJD6CiJXtU4i9qMTVkq6uwW1O1SN49D5qc6oFTchESxYbj2\r\n"
			+ "QadxeC2U/TO/FloDzRdKNeHI9qcmpP621wxXxRxNESfbE/DbRIg=\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn8Lwv/W0zI1j3KljsCyK\r\n"
			+ "uDnDi72D6jAlycnh5e8lkIvawDxyTd863gAwT7uLJTTKGrRy/UfzKQv5fcxk7j0p\r\n"
			+ "xWg4pB6aM0wXK5y3unR6EqRAVvZCxxhHjGdCUB+qXZ+2TKAz18TJse3HkJmhFDi4\r\n"
			+ "3a/bDzlNHkKxYT0534wLSAXVN7AgmFPp9VFw79l1rPBA8Y5RMpOPQIBF0U0KUSEH\r\n"
			+ "lVfpf+OaudmZ3SslbOqj6DutQ1V5o9c0SfEZp6AEmiWYDeS16OEwC18mOT1aI7RB\r\n"
			+ "c1rsOgi50TUrz/7PjDEOMxpVzauZwNTfaOJ+XvVoGIC+0lNf9VZXFa4FNGG5Ns2Y\r\n"
			+ "OQIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";

}
