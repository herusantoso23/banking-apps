# Simple REST Api for Banking Apps

## Technology Used
1. Spring Boot 2.0
2. Oauth2 JWT (Security)
3. PostgreSQL (Database)
4. Mapstruct (Object Mapper)
5. Swagger (Documentation API)
6. Lombok

## How to run
1. Create database 
```
CREATE database banking-apps
```
2. Clone Project from 
```
https://github.com/herusantoso23/simple-rest-api-banking-apps.git
```
3. Run project with command 
```
mvn spring-boot:run
```

## How to see the documentation api
1. Open the browser
2. access this link <b><i>localhost:8080/swagger-ui.html</i></b>

## How to get token
Before you can get token, you must create user with the API that was created, example my user email is <i>herusantoso008@gmail.com</i> and the password is <i>welcome1</i>. To get a JWT token execute the following command: </br>

```
curl adminapp:password@localhost:8080/oauth/token -d grant_type=password -d username=herusantoso008@gmail.com -d password=welcome1
```
and you will get the response like this

```
{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsibXMvYWRtaW4iLCJtcy91c2VyIiwibXcvYWRtaW5hcHAiXSwidXNlcl9uYW1lIjoiaGVydXNhbnRvc28wMDhAZ21haWwuY29tIiwic2NvcGUiOlsid3JpdGUiLCJyZWFkIl0sImV4cCI6MTU1MTAwNDg4MSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6IjViNDVhMjEzLTFmZTctNDg4Zi04YTA4LWNjMDJkYjU0ZjZjOSIsImVtYWlsIjoiaGVydXNhbnRvc28wMDhAZ21haWwuY29tIiwiY2xpZW50X2lkIjoiYWRtaW5hcHAifQ.PF1yByIBS2T_zeG7xDPPNGz5sfYP07KHIoa_mF1PyOYmdtaFqore2-t_CH1mfjC9TG0sghU6lCBc5ryuyq01lszggGLYspSqMOshRhFul7m181FR-TGb__Z-n1-YZbURLMWyo0GAnTFCXuVFua6hw-D89aKelIvyuDaeXbZCrAFZemwDy-SrdsNIqvUaBuurSzwNH_X4rTNCWPTS7b9_vc5C318aP2AhIgy6rSCv9Tp0QcJGFO0AoWT9ULhnUqPJlj9GJAOvzECz6T5vTtsQ8MkO3ijjC6-WlYEhgki8B8d37e863wqD5WabJ4DwqWWt23uV3EnBqizG3VU-2a6huA",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsibXMvYWRtaW4iLCJtcy91c2VyIiwibXcvYWRtaW5hcHAiXSwidXNlcl9uYW1lIjoiaGVydXNhbnRvc28wMDhAZ21haWwuY29tIiwic2NvcGUiOlsid3JpdGUiLCJyZWFkIl0sImF0aSI6IjViNDVhMjEzLTFmZTctNDg4Zi04YTA4LWNjMDJkYjU0ZjZjOSIsImV4cCI6MTU1MDk5OTQ4MSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6ImUzODBmNGExLTYyNGMtNDkxMC1iMDYyLWZiZjJiNjlhYWQ2MCIsImVtYWlsIjoiaGVydXNhbnRvc28wMDhAZ21haWwuY29tIiwiY2xpZW50X2lkIjoiYWRtaW5hcHAifQ.H4iZmB-h8dGRNeVL6br7BPSaT4GGmn7IPiAwmdQlIQt0aV7JpLAKsx6yWE2lIflbdYBPlOJxLc7blUC9rfPaRBLW1Lwl0QXVqQp1hfoOUXjmGX4GDy-3om_PaqZHRlP06gjIDMYRJ5CI3vS9egFd7X7XrwOSZ8X0xTi4UTGhhsXi-3AdhDmpRs9TuNbluVjZGUBcDvQ9yKm-Nn8EeWNRj8ZKti9oCLXx1xgN6yqYNvuotexhuTEXSrCMoA2eSYa5pUxjGBAfzocREzT9ik972SMalP0FPNgsdnRsjt-rJZs_DgDvIh7906IiA0az-tSzdd8mZCbYTbyTww4PJjpxGQ",
    "expires_in": 8999,
    "scope": "write read",
    "email": "herusantoso008@gmail.com",
    "jti": "5b45a213-1fe7-488f-8a08-cc02db54f6c9"
}
```

## How to access the resource
To access a resource use :

```
curl localhost:8080/api/v1/user -H 'Authorization: Bearer {access_token}'
```
