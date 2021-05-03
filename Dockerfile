FROM nginx:1.20.0-alpine
COPY ./sirnoob.duckdns.org /var/www/sirnoob.duckdns.org
COPY ./nginx/sirnoob.duckdns.org.conf /etc/nginx/conf.d/sirnoob.duckdns.org.conf
COPY ./nginx/nginx.conf /etc/nginx/nginx.conf
EXPOSE 8080
