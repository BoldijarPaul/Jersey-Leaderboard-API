# Jersey-Leaderboard-API
**What's this?**
A simple REST api written in Java with Jersey.
You can get, add or delete scores to the leaderboards.

Deployed to - http://api-leaderboards.rhcloud.com/api/ , you can test the API with this service if you want.
**API Documentation**
=================
Note: all are GET requests.
Get all scores
--------------
All scores will be sorted by the value.
> domain.com/api/**scores/getall**

Response example:

  

```javascript
{
  message: "Success",
  code: 1,
  data: [
    {
      value: 364648,
      currentDate: 1431522008189,
      username: "GEORGE0.13899611714656512"
    },
    {
      value: 938649,
      currentDate: 1431522008190,
      username: "GEORGE0.702204956404988"
    }
  ]
}
```

Get first n scores
--------------
All scores will be sorted by the value.
You are going to get the first n scores.
Example: 
> domain.com/api/**scores/gettop/5**
> 
> domain.com/api/**scores/gettop/10**
> 
> domain.com/api/**scores/gettop/50**

Response example (same as the getall request):

  

```javascript
{
  message: "Success",
  code: 1,
  data: [
    {
      value: 364648,
      currentDate: 1431522008189,
      username: "GEORGE0.13899611714656512"
    },
    {
      value: 938649,
      currentDate: 1431522008190,
      username: "GEORGE0.702204956404988"
    }
  ]
}
```


Add score
---------

> domain.com/api/**scores/add?value=1231&name=Paul**

The response will also contain the new score that we just added.
Response example:

```javascript
{
  message: "Score successfully added!",
  code: 1,
  data: {
    value: 1231,
    currentDate: 1431543293836,
    username: "paul"
  }
}
```

Delete score
---------

> domain.com/api/**scores/delete?value=1231&name=Paul**

This request will delete all the scores with the name and value specified.
Response example:

```javascript
{
  message: "2 scores deleted",
  code: 1
}
```



Request results
---------------
	SUCCESS = 1
	PARAMETER_MISSING = 2
	INVALID_VALUE = 3;

Feel free to contact me anytime at paul.bv96@yahoo.com if you need any help.

