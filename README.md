# [The Basics Blog](https://the-basics.space)

## Remaining work

### API

- [ ] get all category under the type
- [ ] get detail blog
- [ ] get all blog under category
- [ ] handle exception
- [ ] add check style and sonar
- [ ] add docker

### FE

- [ ] init ui
- [ ] Create ui as much elegant as I can
- [ ] docker with standard alone
- [ ] how to deploy ?

## Set-up

### BE

- Step 1: create env variable call X_API_KEY_THE_BASICS and enter your value
- Step 2: Run app


curl -X POST --location "http://localhost/api/v1/admin-blogger/blogs" \
    -H "Content-Type: application/json" \
    -d '{
          "id" : 0,
          "createdBy" : "",
          "updateBy" : "",
          "title" : "",
          "nextBlog" : "",
          "previousBlog" : "",
          "slug" : "",
          "cateId" : 0,
          "isShow" : true
        }'
###
curl -X PUT --location "http://localhost/api/v1/admin-blogger/blogs-content" \
    -H "Content-Type: application/json" \
    -d '{
          "id" : 0,
          "content" : "",
          "createdBy" : "",
          "updatedBy" : ""
        }'
###
curl -X POST --location "http://localhost/api/v1/admin-blogger/blogs-content" \
    -H "Content-Type: application/json" \
    -d '{
          "id" : 0,
          "content" : "",
          "createdBy" : "",
          "updatedBy" : ""
        }'
###
curl -X PUT --location "http://localhost/api/v1/admin-blogger/blogs/0" \
    -H "Content-Type: application/json" \
    -d '{
          "id" : 0,
          "createdBy" : "",
          "updateBy" : "",
          "title" : "",
          "nextBlog" : "",
          "previousBlog" : "",
          "slug" : "",
          "cateId" : 0,
          "isShow" : true
        }'
###
curl -X POST --location "http://localhost/api/v1/admin-blogger/categories" \
    -H "Content-Type: application/json" \
    -d '{
          "id" : 0,
          "name" : "",
          "slug" : "",
          "prefix" : "",
          "isShow" : true,
          "parent" : ""
        }'
###
curl -X PUT --location "http://localhost/api/v1/admin-blogger/categories/0" \
    -H "Content-Type: application/json" \
    -d '{
          "id" : 0,
          "name" : "",
          "slug" : "",
          "prefix" : "",
          "isShow" : true,
          "parent" : ""
        }'
###
curl -X POST --location "http://localhost/api/v1/admin-blogger/initialize" \
    -H "Content-Type: application/json" \
    -d '{ }'
###
curl -X GET --location "http://localhost/api/v1/admin-blogger/status"
###
curl -X GET --location "http://localhost/api/v1/blogs/categories"
###
curl -X GET --location "http://localhost/api/v1/blogs/detail/string"
###
curl -X GET --location "http://localhost/api/v1/blogs/status"
###
curl -X GET --location "http://localhost/api/v1/blogs/string"