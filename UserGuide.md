### Get Token
#### Type Post : http://localhost:2002/api/v5/token
#### Query Params >> 
             grant_type = password
             username   = chamath
             password   = 1234
#### Authorization 
     Basic Auth 
         username Web
         password 1234

    Respose ::  
    {
        "access_token": "16daf9fc-b18b-4533-9e03-39597614c970",
        "token_type": "bearer",
        "refresh_token": "c26bc178-9db0-4a48-871d-cd67b2b57ac1",
        "expires_in": 999997382,
        "scope": "READ WRITE",
        "authorize": "Uk9MRV9vcGVyYXRvcg=="
    }
------------
### Add User
#### Type Post: http://localhost:2002/api/v5/oauth/user/customer/registration
#### Body

	{
		"username" : "SSSSdsSsASAS",
		"email":"gdfgssadfsds.lks",
		"password" :"dsdsdsd"

	}
	

------------
### Get New Token From Refresh Token
#### Type Post : http://localhost:2002/api/v5/token?refresh_token=c26bc178-9db0-4a48-871d-cd67b2b57ac1
#### Query Params >>
             grant_type = refresh_token
#### Authorization
     Basic Auth 
         username Web
         password 1234

------------
### Add Role 
#### Type Post : http://localhost:9192/api/v5/oauth/role/create/role_Test
#### Headers >>
             Authorization  bearer 2026f9dc-ec1b-4199-85c1-c1196855229e
------------
### Save Client 
#### Type Post : http://localhost:9191/api/v5/oauth/client/registration
#### Headers >>
             Authorization  bearer 2026f9dc-ec1b-4199-85c1-c1196855229e
             Content-Type   application/json

    {
	"clientId" :"222",
	"clientSecret":"mobilea2",
	"accessTokenValidity":23600,
	"additionalInformation":"",
	"authorizedGrantTypes":"authorization_code,password,refresh_token,implicit",
	"clientSecret" : "1234",
	"refreshTokenValidity" : 1000,
	"resourceIds" : "inventory,payment",
	"scope" : "READ,WRITE"
    }
------------
### Add Permission To Role
#### Assumption : User Has Permission to Delete
#### Type Post : http://localhost:9191/api/v5/oauth/assignPermission
#### Headers >>
             Authorization  bearer 2026f9dc-ec1b-4199-85c1-c1196855229e
             Content-Type   application/json

                 {
				   "roleName": "ROLE_admin",
				   "permission": 
					 {
						"id": 4,
						"name": "read_profile"
					 }					
                 }
	
	
------------
### DELETE To Role
#### Assumption : User Has Permission to Delete
#### Type Delete : http://localhost:9191/api/v5/oauth/role/remove/ROLE_chamath
#### Headers >>
             Authorization  bearer 2026f9dc-ec1b-4199-85c1-c1196855229e
             Content-Type   application/json
------------
### DELETE Role From User
#### Assumption : User Has Permission to Delete
#### Type Delete : http://localhost:9191/api/v5/oauth/role/remove
#### Headers >>
             Authorization  bearer 2026f9dc-ec1b-4199-85c1-c1196855229e
             Content-Type   application/json
	{
	"userName": "chamath",
	
	"role": 
		{
			"id": 2,
			"name": "ROLE_operator"
			
		}
    }
	
------------
### DELETE Permission From User
#### Assumption : User Has Permission to Delete
#### Type Delete : http://localhost:9191/api/v5/oauth/removePermission
#### Headers >>
             Authorization  bearer 2026f9dc-ec1b-4199-85c1-c1196855229e
             Content-Type   application/json
	{
				"roleName": "ROLE_admin",
				"permission": 
					{
						"id": 2,
						"name": "read_profile"
					}					
			}
	
	
	
------------
### Check Token
#### Type Delete : http://localhost:9191/api/v5/authorize?token=32c311ad-0151-402f-ad00-242060d79cad
#### Headers >>
             Authorization  bearer 2026f9dc-ec1b-4199-85c1-c1196855229e

	
	