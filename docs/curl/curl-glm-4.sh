curl -X POST \
        -H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsInNpZ25fdHlwZSI6IlNJR04ifQ.eyJhcGlfa2V5IjoiZWE1Yzg0ZDFjNThhNGRjYWJkZTdkM2M3MDVhOWU3ZWEiLCJleHAiOjE3NjA3MTA5NDA4MzgsInRpbWVzdGFtcCI6MTc2MDcwOTE0MDg0Mn0.-nlMyAKcZHqxkPAy3Deey6k5hTxKtUthrAo_WKVAu60
" \
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