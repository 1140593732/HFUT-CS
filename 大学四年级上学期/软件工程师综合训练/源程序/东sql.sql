--insert into teacher(teaNo,teaName,teaDept,teaDuty,teaTitle)
--values('2018211970','���','�����Ժ','ѧ��','����')
--insert into teacher(teaNo,teaName,teaDept,teaDuty,teaTitle)
--values('2018211958','���','�����Ժ','ѧ��','����')
--select * from teacher

--insert into project(proNo,proName,proCK,teaNo)
--values('0001','������Ŀ1','0','2018211970')
--insert into project(proNo,proName,proCK,teaNo)
--values('0002','������Ŀ2','1','2018211970')
--insert into project(proNo,proName,proCK,teaNo)
--values('0003','����Ŀ1','0','2018211958')
--insert into project(proNo,proName,proCK,teaNo)
--values('0004','����Ŀ2','1','2018211958')
--select * from project

--select * from adminView

 /*update project
 set proCK=0*/

--���崥������
--palnA
/*
create trigger audit
on project
after update
as
if(update(proCK))
begin
  declare @newproCK nchar(1),@oldproCK nchar(1)
  select @newproCK=proCK from inserted
  select @oldproCK=proCK from deleted
  if(@newproCK>@oldproCK)
    print'����ͨ��'
    else
    print'��Ŀ�������������ظ�����' 
  end
 */
 
 --planB
 /*
 
 */
 
 --����������
 /*
 update project
 set proCK='1'where proNo='0003'
 */

--����洢���̣�

create procedure proStats
  as
  begin
      select
           (select COUNT(proNo) FROM project where proCK='1') finCount,
           (select COUNT(proNo) from project ) decCount;
  end


--ִ�д洢���̣�
-- exec dbo.proStats

--Ĭ��ֵ��
/*
alter table project
add constraint proCK default '0' for proCK
*/
/*insert into project(proNo,proName,teaNo)
values('0005','������Ŀ1','2018211970')*/

--select * from adminView