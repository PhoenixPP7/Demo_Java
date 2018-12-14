package _00_Java.SVN;

public class DemoSVN_Maven_GIT {

}

/*
==========SVN(Subversion)
	说明=源于Linux,因为Linux是开源项目,多人同时开发,产生了多人同时开发对程序版本控制的需求;
		SVN属于C/S模式,使用过程中必须有网络(星型网络);
=====SVN服务器端=[svn-1.4.5-setup.exe];安装过程一路next,无脑安装;
	1.创建SVN服务工作区目录(如:"D:\7-program-2018.10.13\Subversion-svn");
	2.配置SVN服务工作区目录
		命令行执行此命令="svnadmin create D:\7-program-2018.10.13\Subversion-svn";
		此命令指将此文件夹设置为SVN服务工作区目录,执行之后会在此文件夹中生成和SVN有关的项目配置文件信息;
	3.配置用户和密码=
		在工作区目录下的"conf"文件夹中有3个文件,"authz"=授权;"passwd"=密码;"svnserve.conf"=服务配置;
		配置"svnserve.conf"文件,打开"authz"授权和"passwd"密码的使用权限;删除其中单个出现的"#",例="# anon-access = read"->"anon-access = read";
		配置"passwd"文件,在文件最下面添加用户名和密码="pp = java";
		配置"authz"文件,详见"D:\7-program-2018.10.13\Subversion-svn\conf\authz";
	4.启动服务=
		命令行执行此命令="svnserve -d -r D:\7-program-2018.10.13\Subversion-svn";
		*执行此命令之后不要关闭CMD命令行窗口,否则将关闭SVN服务;
=====SVN客户端插件=[site-1.6.5]
	说明=将Eclipse作为SVN的客户端,需要手动在Eclipse中配置SVN客户端插件;
		步骤=MyEclipse->help->Instal from Site...->Add->Name="SVN-Client"->Archive="site-1.6.5.zip"->OK->全选->next->next->accept->Finish;
=====使用SVN=在SVN服务器上发布项目(项目主开发者完成)
	1.发布项目=鼠标右键点击项目"DemoSVN"->Team->Share Project...->Next->URL="svn://192.168.1.9"->Next->使用项目名称作为文件夹名->Next->Finish;
		输入用户名和密码="pp java";
	2.提交项目=鼠标右键点击项目"DemoSVN"->Team->提交;
=====使用SVN=程序开发-代码冲突解决(项目主开发者-开发A-开发B...)
	1.从SVN导入项目至本地=File->Import->SVN->从SVN检出项目-Next->创建新的资源库位置->Next->URL="svn://192.168.1.9"->Next->选择要导入的项目->Next->Finish;
	2.本地与SVN服务器同步=鼠标右键点击项目"DemoSVN"->Team->更新(与资源库同步);
	3.本地提交文件至SVN服务器=鼠标右键点击想要同步的文件->Team->更新=检查自己要提交的文件是否是SVN中该文件最新版本进行了修改;
		1.基于SVN中最新版本=Team->提交;
		2.基于SVN中旧版本=Team->标记为解决->conflict have been resolved in the file->提交;
=====总结
	1.实际开发中不允许进行整体项目提交,只允许进行项目文件的提交;
	2.不允许提交有错误的项目文件;
	SVN项目说明=
		"*"标识=未与SVN服务器同步;
		"黄色圆柱"标识=项目状态为已与SVN服务器同步;
		"?"表示=未提交至SVN服务器;		
*/

/*
==========Maven
	说明=目前流行开发模式=SpringMVC+IBatis+Maven;Maven可以提供更加方便的"*.jar"文件的管理;
		Maven首次运行会通过网络下载大量的第三方开发包,保存路径="C:\Users\用户名\.m2\repository";为减少下载时间,可以将下载好的此路径拷贝到新电脑上;
=====创建项目时勾选"Add maven support",就增加了Maven支持;
=====配置开发组件(第三方jar文件)=Maven项目中"pom.xml"文件,是整个项目的核心文件,所有需要的第三方开发包都可以在这个文件中进行配置,不需要再单独下载了,可以通过配置此文件动态的取得;
	(详见=DemoMaven项目,pom.xml)通过远程仓库网站"https://mvnrepository.com/"取得想要下载使用的组件=搜索想要使用的开发包,复制该开发包对应的Maven代码,复制到"pom.xml"文件中;
=====(了解)创建Maven项目=New->Maven Project->Next->搜索"maven-archetype-quickstart"->Next->填写=
		开发组织=Group Id="cn.mldn"
		组件名称=Artifact Id="util" 
		包名称=Package="cn.mldn.util"(由Group Id.Artifact Id组成)
		->Finsh;
=====(了解)Maven文件夹=
	"src/main/java"文件夹=保存Java源文件;
	"src/test/java"文件夹=保存测试代码;
=====总结=用了Maven后,对第三方*.jar文件的管理会比较方便;
*/

/*
====================Git和GitHub
	说明=SVN的缺点,必须依赖网络(星型网络);Git不依赖网络且实现了多版本控制;
==========Git
=====安装Git=[Git-2.19.2-64-bit.exe]=一路Next即可安装;注意勾选其中的选项"Git Bash Here",此集成工具用于使用SSH搭建自己的服务器;
=====配置Git全局信息=CMD命令行中操作;
	配置全局信息=[git config --global]
	设置开发者用户名信息=[git config --global user.name 'pp']
	设置开发者用户邮箱信息=[git config --global user.email 'lzp533x@qq.com']
	查看全局信息=[git config --list]
=====创建仓库
	1.先在本地磁盘创建一个用于Git仓库的文件夹"D:\MyEclipse 2015-Git"=[md D:\MyEclipse 2015-Git]
	2.进入此文件夹目录=[cd D:\MyEclipse 2015-Git]
	3.初始化仓库=
		方式1=创建一个包含有配置信息目录的仓库文件夹=[git init];会在当前目录中会自动生成一个".git"隐藏文件夹,这个文件件将包含有全部Git相关信息;
		方式2=直接将当前目录设置为Git仓库=[git init --bare];
=====工作区、暂存区、版本库
	仓库中划分出了3个区域=工作区、暂存区、版本库;
		工作区=用户存放及操作代码文件的文件夹就是工作区,此时的文件并没有保存在Git仓库中,此时的文件增加、修改、删除等操作并不会影响最终软件版本;
		暂存区=将工作区未保存的文件保存在暂存区,此部分由Git维护;
		版本库=项目最终发布的仓库;
=====仓库的基本操作
	说明=仓库中的信息都在Git的监控范围,Git可以对仓库中文件的增加、修改、删除实现监控;
	文件提交流程=在仓库中创建文件修改文件属于"工作区"->通过add命令将文件增加到"暂存区"->通过commit命令提交到"版本库";
	命令=
		查看仓库状态=[git status];
		从工作区增加到暂存区=[git add new.java];
		从工作区所有文件增加到暂存区=[git add .];
		从工作区增加并提交到版本库=[git commit -a -m "PP -a -m"]
		从暂存区提交到版本库,且添加注释信息=[git commit -m "PP Create a New File new.java"]
=====修改仓库文件
	先查看仓库状态,确认修改的文件;
	命令=
		查看文件不同=[git diff new.java];"+"表示增加的代码;"-"表示删除的代码;如果行数太多,不想再展开查看,可以按"Q"退出;
		查看提交历史=[git log new.java];其中"commit"是commit id,可用于代码的版本穿越;
=====版本穿越
	说明=Git的优势在于可以进行版本的回退及前进状态的切换;在Master分支保存有HEAD指针,HEAD指针默认指向最近的操作文件版本Commit ID,通过修改HEAD指针,就实现了版本穿越;
	命令=
		简洁查看日志信息=[git log --pretty=oneline]
		修改HEAD指向的Commit ID=[git reset --hard HEAD~1];其中数字1是指倒数第1个版本(离当前版本最近的版本);
		查看所有删除的(可回退的)提交点(Commit ID)=[git reflog]
		恢复回到最后一次commit命令提交的版本(先通过上一条命令找到7位编码)=[git reset --hard bea4b9e]
	总结=通过HEAD的不同指向"Commit ID"操作,所有的提交点都可以作为恢复点;
=====文件删除
	在工作区中删除文件=[del new.java];此时删除只是作用于工作区,不影响其他区;
	在工作区中恢复删除的文件(通过撤销修改实现)=[git checkout new.java]
	在Master分支中删除文件=[git commit -a -m "注释语句"];例=[git commit -a -m "Delete new.java File"]
	在Master分支中恢复删除的文件(通过版本穿越实现)=[git reset --hard bea4b9e]
=====撤销修改
	需要使用撤销修改功能的情况=
		撤销工作区修改的文件=[git checkout new.java];适用情况=文件在工作区进行了修改,还未提交到暂存区(未add,未commit);
		从暂存区恢复到工作区=[git reset HEAD new.java];适用情况=文件从工作区提交到了暂存区,还未提交到Master分支(已add,未commit);
=====Git总结
	正向操作=工作区->暂存区=[git add .]
	正向操作=暂存区->Master分支(版本库)=[git commit -m "PP Create new.java"]
	逆向操作=工作区-撤销修改=[git checkout new.java]
	逆向操作=暂存区->工作区=[git reset HEAD new.java]
	逆向操作=Master分支(版本库)穿越版本=[git reset --hard HEAD~1]

==========GitHub
	说明=GitHub是一个云端代码仓库服务器,它可以保存各个客户端发送的数据;公共项目(免费)=其他人可以看到项目情况;私有项目(收费)=主要用于工作项目开发;
	网址=www.github.com;
=====配置GitHub远程仓库
	可以通过SSH通讯模式进行远程传输;配置如下=
		1.启动Git Bash=进入想要使用的本地目录->鼠标右键->Git Bash Here->弹出的命令行窗口中可以执行Linux命令;
		2.在此窗口输入生成SSH Key的命令,生成公钥和私钥=
			生成SSH密钥=[ssh-keygen -t rsa -C "lzp533x@qq.com"];
			私钥(保存在本地)和公钥(保存在远端)互相匹配,实现远程服务器的安全连接;
		3.询问输入公钥和私钥的保存位置=(默认情况下会保存在"C:/Users/Administrator/.ssh/id_rsa"目录中)
		4.询问查看公钥和私钥的密码="java";
		5.将公钥配置到GitHub上=
			1.在本地取得公钥文件="C:\Users\Administrator\.ssh"目录中有两个文件=
				"id_rsa"=私钥文件;做本机标识;
				"id_rsa.pub"=公钥文件;保存在外部使用;
			2.登陆GitHub网站->点击右上角头像->setting->SSH and GPG keys->New SSH key->Title="PP";Key="使用记事本打开公钥文件,将其中的内容复制到此处"->Add SSH key->完成;
			以后此电脑就可以通过SSH的连接方式与GitHub进行代码的交互操作了;
		6.在GitHub上增加远程仓库=
			登陆GitHub网站->点击右上角"+"标识->"New repository"->输入仓库名字和备注->跳转至仓库信息页面=
				记录仓库SSH访问地址="git@github.com:PhoenixPP7/DemoJava.git";有了SSH Key可以直接连接;
				记录仓库HTTPS访问地址="https://github.com/PhoenixPP7/DemoJava.git";此地址其他人可以访问;
		7.删除GitHub仓库
			进入仓库->Settings->最下面"Delete this repository";
		
=====连接远程仓库
	建立客户端与服务器端连接=[git remote add origin git@github.com:PhoenixPP7/DemoJava.git];"origin"是自己起的远程主机名称;
	其他命令=
		查看当前远程访问=[git remote -v]
		删除本地仓库与远程仓库的连接配置=[git remote rm origin];
		修改远程访问地址=[git remote set-url origin git@github.com:PhoenixPP7/GitHub.git];如切换SSL和HTTPS访问方式;
=====克隆远程仓库
	说明=在GitHub网站创建仓库时勾选"Initialize this repository with a README",则在创建仓库的时候同时完成了初始化工作,此仓库直接可以使用开始开发了;本地端可以通过SSH或HTTPS的方式取得远程仓库;
		克隆远程仓库命令=[git clone https://github.com/PhoenixPP7/GitHub.git]
			除了克隆自己的仓库之外,还可以克隆其他人的远程仓库;
			例=BootStrap的仓库=[https://github.com/twbs/bootstrap],[https://github.com/twbs/bootstrap.git];
			例=MyBatis(实体层设计框架)=[https://github.com/mybatis]
=====Git分支=分支创建和分支合并
	说明=如果项目需要回到某个开发时间节点,传统的方式是一个个恢复单个文件;Git提供多分支操作,每个分支都可以作为一个完整运行的项目,通过选择不同分支项目的开发更方便;通过"HEAD"、"master分支"、"自定义分支"实现;
		"HEAD"=HEAD类似指针,它负责控制项目使用哪个分支;
		"自定义分支"=实际开发中应在其他自定义的分支上开发;
		"master分支"=master分支是正式发布使用的分支,只有最终正式发布项目时才将HEAD定义在Master分支上;
	命令=
		查看所有分支=[git branch];其中"*"标记的是当前使用的分支;
		创建并切换至"dev"分支上=[git checkout -b dev];
			创建名叫"dev"的分支=[git branch dev];
			切换至"dev"分支上=[git checkout dev];
		合并"master"分支和"dev"分支=[git merge dev];此命令需在最终使用的"master"分支上操作;且在合并前只修改了"dev"分支,"master"分支未进行修改;此命令默认使用"Fast-forward",是快速合并;
		上传"master"分支至远程仓库=[git push -u origin master];输入密码"java"->完成;其中"-u origin master"意味着将本地master分支的远程上传目标默认设置为origin主机,以后再上传直接[git push]即可;
		删除"dev"分支=[git branch -d dev]
		强制删除"dev"分支=[git branch -D dev];如果某分支因为有未保存的文件,导致无法普通删除,而文件又不需要合并到master分支上的时候使用;
		删除远程仓库的"dev"分支=[git push origin --delete dev]
			删除远程仓库中的"dev"分支方式2=向远程仓库上传一个空的"dev"分支=[git push origin:div]
=====补充-分支合并
	说明=分支合并=[git merge dev],此命令使用"Fast-forward",是快速合并,有如下缺点=不会产生新的提交点,无法通过分支日志查看到;
	命令=
		图形化界面查看分支合并记录=[git log --graph --pretty=oneline];也可以进入工作区,鼠标右键选择"Git GUI Here"
		非"Fast-forward"方式合并分支=[git merge --no-ff -m "操作注释"];其中参数"--no-f"代表Not Fast Forwar的意思;
	总结=实际开发中不允许在master分支上直接开发,应建立一个dev子分支,然后再在dev分支上创建自己的子分支,在自己的子分支上开发;
		合并顺序=各个开发者的子子分支-合并->dev子分支-合并->master分支;其中的合并不应使用"Fast-forward"方式;
=====处理分支冲突
	说明=两个不同的分支修改了同一个文件,那么分支合并的时候会发生冲突,需按冲突提示进行修改;
		例="dev"分支修改了A文件,"master"分支也修改了A文件,在"master"分支上合并"dev"分支,会提示合并失败A文件有冲突;此时应按Git文件冲突提示修改A文件,然后先增加并提交文件,最后合并分支;
=====多人协作开发
	说明=Git的核心目的是解决多人同时开发代码维护问题;必须明确的是master分支不允许用于开发;
	命令=
		查看本地仓库对应的远程仓库地址=[git remote -v]
			[origin  git@github.com:PhoenixPP7/GitHub.git (fetch)];fetch=抓取;
			[origin  git@github.com:PhoenixPP7/GitHub.git (push)];push=推送;
	第二个开发者需要做的如下=
		从GitHub服务器将统一开发的项目克隆下来,在想要存放项目的工作区执行命令=
			[git clone git@github.com:PhoenixPP7/GitHub.git];
		抓取分支数据=
			[git pull];抓取"本地执行此命令的分支"对应的"GitHub上的分支"上的数据;
		(建议)将远程仓库dev分支的内容抓取到本地的dev分支=
			[git check -b dev origin/dev];"origin"可以理解为远程仓库
		(不建议)将远程dev分支和本地的dev分支中名称绑定合并=
			步骤1=[git branch --set-upstream-to=origin/dev dev];
		(不建议)抓取分支数据
			步骤2=[git pull];(抓取"本地执行此命令的分支"对应的"GitHub上的分支",不同名称的分支可通过上一个命令进行绑定)
	举例=开发者1修改并上传了A文件至dev分支,开发者2之后修改并上传A文件至dev分支时,会提交失败;
		应先执行[git pull]命令,从服务端抓取最新的分支情况,然后查看不同步的代码并手动修改解决冲突;
	总结=默认下本地上传项目或从服务端克隆项目,得到的是相同名称的分支;
		多人同时开发时会将服务端分支统一叫"dev"分支,各个开发者使用自己命名的分支;此时各个开发者上传分支时应进行绑定,或每次手动指定"源分支:目标分支",例=[git push origin pp:dev];
		建议本地分支与远程分支名称一致;如遇无法通过[git pull]抓取服务端程序至本地,检查分支名称/分支是否绑定;
=====标签管理
	说明=为提交点(Commit ID)创建标签(如=v1.0版本),可以方便直观的管理,版本穿越时可以根据标签名称穿越;
	命令=
		查看所有标签=[git tag]
		查看"v1.0"标签=[git show v1.0]
		将当前提交点设置为"v1.0"标签=[git tag v1.0]
		将当前提交点设置为"v1.0"标签并增加注释=[git tag v1.0 -m "Init"]
		将提交点"c90fe8a"设置为"v0.5"标签=[git tag v0.5 c90fe8a]
			查看提交点(简洁模式)=[git log --pretty=oneline --abbrev-commit]
		删除标签=[git tag -d v1.0]
	服务器交互命令=
		将名称为"v1.0"的标签上传到服务端=[git push origin v1.0]
		将所有标签都提交到服务端=[git push origin --tags]
		将服务器上名称为"v1.0"的标签删除=[git push origin :refs/tags/v1.0]
=====在Eclipse中使用GitHub
	说明=Eclipse和GitHub服务器通过SSH方式连接必须设置好私钥和公钥;通过HTTP方式连接需输入GitHub账号和密码;
		步骤1=Eclipse设置私钥"id_rsa";
		步骤2=GitHub设置公钥"id_rsa.pub";
		步骤3=在Eclipse中使用GitHub
	步骤1=Eclipse设置私钥"id_rsa"=
		Eclipse->Window->Perferences->General->Network Connections->SSH2->Key Management->"创建密钥=Generate RSA Key"或"加载已有密钥=Load Existing Key..."(选择本地私钥文件"id_rsa");
			注意=创建密钥="Generate RSA Key",如果保存在"C:\Users\Administrator\.ssh"目录,会覆盖已有密钥;
	步骤2=GitHub设置公钥"id_rsa.pub"
		使用记事本打开本地公钥文件="C:\Users\Administrator\.ssh\id_rsa.pub",复制公钥代码;
		打开GitHub服务器端="Settings"->SSH and GPG keys->New SSH key->"Title=填写公钥名称";"Key=粘贴进去复制的公钥代码";
	步骤3=在Eclipse中使用GitHub
		将项目变为Git仓库=鼠标右键点击项目->Team->Share Project->GIt->勾选"Use or create repository in parent folder of project"->勾选项目->"Create Repository"->Finish;
		将仓库的项目由工作区保存到版本库并上传至GitHub服务器=鼠标右键点击项目->Team->Commit->在"Commit message"填写项目注释->选择"Commit And Push"->"URI"填写服务器SSH地址->Next->Next->Finish;
		切换本地分支=鼠标右键点击项目->Team->Switch To->"Branch name"填写分支名字;切换成功后本地项目名称后面会有相应分支名称显示;
=====使用CopSSH搭建私服Git服务器
	1.安装程序=[Copssh_4.1.0_Installer.exe];安装过程一路Next;注意=安装过程中的"Service account"=pp;"Type password"=java;
	2.设置开发人员=
		版本控制人员=verman_xxx;
		程序开发人员=coder_xxx;如=coder_pp;
		程序测试人员=tester_xxx;
	3.以上人员须在Windows的系统用户中建立=计算机管理->本地用户和组->用户->新用户->"用户名"=coder_pp;"密码"=java;不勾选"用户下次登录时须更改密码";勾选"用户不能更改密码"和"密码永不过期";
	4.在Copssh程序中配置人员,此用户就具备了访问CopSSH服务的权限;开始->Copssh->01.COPSSH Control Panel->Users->Add->Forward->"User"=coder_pp->Forward->不勾选"Allow password authentication"->Forward->Apply;
	5.配置用户的SSH key;
		拷贝该用户公钥文件[C:\Users\Administrator\.ssh\id_rsa.pub]至CopSSH的[D:\7-program-2018.10.13\Copssh\home\coder_pp\.ssh]目录中;并将文件名称"id_rsa.pub"改为"authorized_keys";(如还有其他用户,将内容复制进去即可)
		在COPSSH Control Panel->Users->Keys...处可以看到该公钥信息;
	6.连接copssh服务器;
		打开git bash,执行命令实现连接=[ssh coder_pp@192.168.1.15];此时虽已连接,但还无法使用git命令;
	7.解决git命令无法在copssh中使用的问题;
		说明=因为在copssh中无法直接使用git命令,所以需要进行如下配置=
		步骤1=记录Git安装目录下的此2个目录,此2个目录保存的是git的执行命令=
			目录1=[D:\7-program-2018.10.13\Git\mingw64\bin]
			目录2=[D:\7-program-2018.10.13\Git\mingw64\libexec\git-core]
		步骤2=在copssh中修改此2个文件,配置git的执行命令路径=
			文件1=[D:\7-program-2018.10.13\Copssh\etc\profile]
			文件2=[D:\7-program-2018.10.13\Copssh\home\coder_pp\.bashrc]
			在文件1中此行[export PATH="/bin:$syspath:$winpath"]改为=(注意copssh相当于是Linux环境,Linux中对路径的描述与Windows不同,具体见如下)
				[export PATH="/bin:$syspath:$winpath:/cygdrive/D/7-program-2018.10.13/Git/mingw64/bin:/cygdrive/D/7-program-2018.10.13/Git/mingw64/libexec/git-core"]
			在文件2的73行同样粘贴上上面这行配置;
	8.重新启动copssh服务;
		[COPSSH Control Panel]程序->Status->点击"Service is running"关闭->再点击"Service is running"开启服务;
	9.使用git bash重新连接,输入命令[git]验证是否可以使用git命令;
	10.使用copssh搭建的Git服务器
		测试=
			使用git bash连接copssh搭建的Git服务器,在上面创建一个仓库"mldn.git"并初始化;
			使用CMD命令行或Eclipse中使用git命令将其克隆下来;[git clone coder_pp@192.168.1.15:mldn.git]

==========Git-其他功能补充
=====Bug分支
	说明=Git提供有暂挂功能,主要应用场景是突然新增修改master分支上Bug时的情况,此时可以将正在开发的工作区暂时挂起(因为是正在开发的程序,所以不允许进行增加或提交操作),
		然后切换至master分支上,在master分支上创建一个bug分支,并进入bug分支修改错误,完成后将master和bug分支合并,然后删除bug分支;
		当处理完如其他临时工作后,从暂存区再恢复到之前的工作区继续开发;可以将其理解成为方便Bug修复提供的功能;
	命令=
		暂时挂起工作区=[git stash];
		查看所有暂时挂起的工作区=[git stash list];
		恢复暂时挂起的工作区=
			方式1(1步完成,建议)=[git stash pop]
			方式2(2步完成)=	步骤1=恢复暂时挂起的工作区=[git stash apply];	步骤2=删除暂时挂起的工作区=[git stash drop]
=====feature分支(扩展分支)
	说明=临时的扩展分支,可用于开发项目扩展功能;
	命令=
		创建并且换到feature分支=[git checkout -b feature];删除此分支使用=强制删除"dev"分支=[git branch -D dev];
=====补丁形式上传
	说明=用于某些文件只进行了小修改,项目更新发布的时候没必要整个项目都更新发布,只更新这些文件就可以了的情况;
		例="dev"分支修改了一个文件,进行了增加和提交操作后,正常流程是切换至"master"分支然后合并2个分支,但本次修改内容很少,使用补丁的形式较合适,将"master"和"dev"上不同的内容设置为一个保存的补丁文件;
	使用如下操作=		
		在"dev"分支上执行此命令=[git diff master > patch];使用管道输出流,将所有有区别的信息保存在了"patch"文件中;
		然后在"master"分支上编辑batch文件,确认无误后执行此命令=[git apply batch];
	总结=此方式适用于较大的项目进行了较小修改,每次只更新修改的内容即可,性能较好;
*/