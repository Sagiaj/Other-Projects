% x1=[0 randi([0 10],1,4) 0];
% y1=[2 randi([0 10],1,4) 2];
% x2=[3 randi([(min(x1)+1) (max(x1)-1)],1,3) 3];
% y2=[4 randi([(min(y1)+1) (max(y1)-1)],1,3) 4];
% x1=randi([0 10],1,5);
% y1=randi([0 10],1,5);
% x2=randi([4 8],1,5);
% y2=randi([4 8],1,5);
% x1=[2 3 8 9 10 2];
% y1=[4 6 5 2 1 4];
x1=randi([1 8],1,8);
y1=randi([0 9],1,8);
x2=randi([1 5],1,4);
y2=randi([3 7],1,4);
K1 = convhull(x1,y1);
K2 = convhull(x2,y2);
[xi,yi]=polyxpoly(x1(K1),y1(K1),x2(K2),y2(K2));
p=[x1 y1];
q=[x2 y2];
%plot(x1,y1,'r-');
%plot(x2,y2,'g-');
plot(x1(K1),y1(K1),'r-');
hold on;
plot(x2(K2),y2(K2),'b-');
intersection=[xi yi];
if(isempty(intersection))
%     [in,on]=inpolygon(x2,y2,x1,y1);
%     arr=[in,on];
    arr=inpolygon(x2(K2),y2(K2),x1(K1),y1(K1));
    if(not(isempty(arr))&&max(x2)<max(x1)&&min(x2)>min(x1)&&max(y2)<max(y1)&&min(y2)>min(y1))
        contained=1;
        strange=0;
    else
        contained=0;
        strange=1;
    end
else
    contained=0;
    strange=0;
end
hold off;
% x=linspace(-1,5,1000);
% y1=sin(x);
% y2=cos(x);
% figure;
% plot(x,y1);
% hold on;
% plot(x,y2,'r-');
% xx=0:2:2;
% plot(xx);