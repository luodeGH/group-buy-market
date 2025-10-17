curl -X POST \
        -H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsInNpZ25fdHlwZSI6IlNJR04ifQ.eyJhcGlfa2V5IjoiZWE1Yzg0ZDFjNThhNGRjYWJkZTdkM2M3MDVhOWU3ZWEiLCJleHAiOjE3NjAzNjE4ODg5ODAsInRpbWVzdGFtcCI6MTc2MDM2MDA4ODk4MX0.G7XAb-VUFo3XC17LefAhpBswC649_OWutT8D525vJqA" \
        -H "Content-Type: application/json" \
        -H "User-Agent: Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)" \
        -d '{
          "model":"glm-4",
          "stream": "true",
          "messages": [
              {
                  "role": "user",
                  "content": "1+1"
              }
          ]
        }' \
  https://open.bigmodel.cn/api/paas/v4/chat/completions