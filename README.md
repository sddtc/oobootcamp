# ParkingLot
## Tasks
given 一个停车场有一个空车位  
when 停入汽车  
then 停车成功返回一个凭证  

given 一个停车场有2个空车位  
when 依次停入2辆汽车  
then 停车成功返回2个不同凭证  

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
when 使用凭证连续取出两次汽车  
then 第一次取车成功，第二次取车失败    

## new parking car boy  
## Tasks  
given 停车小弟管理两个停车场，第一个停车场有一个空车位，第二个停车场有2个空位  
when 停车小弟停入1辆汽车  
then 停车到第1个停车场并成功返回一个凭证  

given 停车小弟管理两个停车场，第一个停车场有2个空车位，第二个停车场有1个空位  
when 停车小弟停入1辆汽车    
then 停车到第一个停车场并成功返回一个凭证  

given 停车小弟管理三个停车场，第一个停车场有0个空车位，第二个停车场有1个空位, 第三个停车场有2个车位  
when 停车小弟依次停入2辆汽车  
then 第一辆停入第二个停车场，第二辆停入第三个停车场，停入成功并返回一个凭证  

given 停车小弟管理两个停车场，第一个停车场有0个空车位，第二个停车场有0个空位  
when 停车小弟停入汽车  
then 停入失败  

given 我有一张该停车场的取车凭证 
when 停车小弟取出汽车  
then 取车成功

given 我有一张该停车场的取车凭证 
when 停车小弟连续两次取出汽车  
then 第一次取车成功，第二次取车失败  

given 停车小弟管理了2个停车场，我的车停在第二个停车场，我有一张该停车场的取车凭证 
when 停车小弟用有效的凭证取车  
then 取车成功 

## smart parking car boy
## Tasks  
given 停车小弟管理两个停车场，第一个停车场有一个空车位，第二个停车场有2个空位  
when 停车小弟停入汽车  
then 停车到第二个停车场并成功返回一个凭证  

given 停车小弟管理两个停车场，第一个停车场有2个空车位，第二个停车场有1个空位  
when 停车小弟停入汽车    
then 停车到第一个停车场并成功返回一个凭证  

given 停车小弟管理三个停车场，第一个停车场有0个空车位，第二个停车场有1个空位, 第三个停车场有1个空车位
when 停车小弟停入汽车  
then 成功停入第二个停车场并返回一个凭证  

given 我有一张该停车场的取车凭证 
when 停车小弟取出汽车  
then 取车成功

given 我有一张该停车场的取车凭证 
when 停车小弟连续两次取出汽车  
then 第一次取车成功，第二次取车失败  

given 停车小弟管理了2个停车场，我的车停在第二个停车场，我有一张该停车场的取车凭证 
when 停车小弟用有效的凭证取车  
then 取车成功 

## super parking car boy
## Tasks  
given 停车小弟管理两个停车场，第一个停车场车位有1个并有1个空车位，第2个停车场车位有2个并有1个空车位  
when 停车小弟停入汽车  
then 停车到第1个停车场并成功返回一个凭证  

given 停车小弟管理两个停车场，第一个停车场车位有2个并有1个空车位，第2个停车场车位有1个并有1个空车位  
when 停车小弟停入汽车  
then 停车到第2个停车场并成功返回一个凭证  

given 停车小弟管理两个停车场，第一个停车场车位有1个并有1个空车位，第2个停车场车位有1个并有1个空车位  
when 停车小弟停入汽车  
then 停车到第1个停车场并成功返回一个凭证   

given 我有一张该停车场的取车凭证 
when 停车小弟取出汽车  
then 取车成功

given 我有一张该停车场的取车凭证 
when 停车小弟连续两次取出汽车  
then 第一次取车成功，第二次取车失败  

given 停车小弟管理了2个停车场，我的车停在第二个停车场，我有一张该停车场的取车凭证 
when 停车小弟用有效的凭证取车  
then 取车成功 

## parking car manager
## Tasks
given 1个停车管理员管理1个停车小弟，这个小弟有一个停车场并且有一个空位
when 有1辆车需要停
then 停车小弟停车成功返回一个凭证

given 1个停车管理员管理2个停车小弟，小弟个有一个停车场并且有一个空位
when 有2辆车需要停
then 两个小弟分别停车成功，均成功返回凭证

given 1个停车管理员管理1个停车小弟，这个小弟有一个停车场并且没有空位
when 有1辆车需要停
then 停车管理员自己停车成功

given 我有一辆车需要取出来，用有效的凭证去找管理员
when 取车
then 管理员取车成功
