# 普通镜像构建，随系统版本构建 amd/arm
docker build -t fuzhengwei/group-buy-market-app:3.0 -f ./Dockerfile .

# 兼容 amd、arm 构建镜像