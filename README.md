# ParkingLot
## Tasks
given 一个停车场有一个空车位  
when 停入汽车  
then 停车成功返回一个凭证  

given 一个停车场有2个空车位  
when 依次停入2辆汽车  
then 停车成功返回2个凭证  

given 一个停车场有一个空车位  
when 依次停入2辆汽车  
then 停车成功一辆，失败一辆  

given 一个停车场有0个空车位  
when 停入汽车  
then 停车失败  

given 一个停车场用一个凭证  
when 取出汽车  
then 取车成功  

given 一个停车场不拿凭证  
when 取出汽车  
then 取车失败  

given 一个停车场使用不合法的凭证  
when 取出汽车  
then 取车失败  

given 一个停车场用一个凭证  
when 取出汽车  
then 取车成功,释放一个空车位    

## Parking car boy

given 停车小弟管理两个停车场，第一个停车场有一个空车位，第二个停车场有一个空位  
when 停车小弟停入汽车  
then 停车到第一个停车场并成功返回一个凭证 

given 停车小弟管理两个停车场，第一个停车场有2个空车位，第二个停车场有2个空位  
when 停车小弟依次停入汽车两辆汽车  
then 均停车到第一个停车场并成功返回一个凭证  

given 停车小弟管理两个停车场，第一个停车场有0个空车位，第二个停车场有1个空位  
when 停车小弟停入汽车  
then 停入成功并返回一个凭证  

given 停车小弟管理两个停车场，第一个停车场有0个空车位，第二个停车场有0个空位  
when 停车小弟停入汽车  
then 停入失败  

given 我有一张该停车场的取车凭证 
when 停车小弟取出汽车  
then 取出成功
