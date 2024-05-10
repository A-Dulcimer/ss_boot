尚硅谷ssm整合springboot微头条项目代码




sql：
CREATE DATABASE sm_db;

USE sm_db;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for news_headline
-- ----------------------------
DROP TABLE IF EXISTS `news_headline`;
CREATE TABLE `news_headline`  (
  `hid` INT NOT NULL AUTO_INCREMENT COMMENT '头条id',
  `title` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '头条标题',
  `article` VARCHAR(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '头条新闻内容',
  `type` INT NOT NULL COMMENT '头条类型id',
  `publisher` INT NOT NULL COMMENT '头条发布用户id',
  `page_views` INT NOT NULL COMMENT '头条浏览量',
  `create_time` DATETIME(0) NULL DEFAULT NULL COMMENT '头条发布时间',
  `update_time` DATETIME(0) NULL DEFAULT NULL COMMENT '头条最后的修改时间',
  `version` INT DEFAULT 1 COMMENT '乐观锁',
  `is_deleted` INT DEFAULT 0 COMMENT '头条是否被删除 1 删除  0 未删除',
  PRIMARY KEY (`hid`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of news_headline
-- ----------------------------
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (1, '特色产业激发乡村振兴新活力', '推进中国式现代化，必须全面推进乡村振兴。习近平总书记指出，产业振兴是乡村振兴的重中之重，也是实际工作的切入点。近日，记者走进乡村一线，看到各地以特色产业为抓手，拓展产业链发展产业集群，一二三产业融合发展，培育乡村振兴新动能。\n\n　　这个端午，广东茂名高州市根子镇柏桥村的荔枝迎来了丰收。今年4月，习近平总书记来到柏桥村考察调研。总书记走进荔枝种植园，了解当地发展特色种植产业和文旅产业等情况，并同现场技术人员亲切交流。', 1, 1, 0, '2023-06-25 09:26:20', '2023-06-25 09:26:20', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (2, '北京连续三天最高温超40℃，6月“炎值”因何爆表？', '　中新社北京6月24日电 (记者 陈杭 徐婧)京城连续三日“热晴不减”，且高温红色预警持续生效。截至24日13时51分，作为北京地区气象观测代表站的南郊观象台气温突破40℃，这是该站观测史上首次连续三天气温超40℃。22日以来，北京高温“烤验”突出。22日，北京南郊观象台最高气温达41.1℃，这是有观测纪录以来历史第二高(并列)。北京市气象局表示，观象台1951年建站以来极端最高气温为41.9℃，出现在1999年7月24日。\n\n　　23日，北京南郊观象台最高气温为40.3℃，这是该观象台建站以来首次出现连续两天最高气温超40℃。当天，北京时隔9年再次发布最高级别的高温红色预警信号。', 1, 1, 0, '2023-06-25 09:28:06', '2023-06-25 09:28:06', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (3, '今年夏天，极端高温是否会成为常态？', '针对京津冀地区持续高温天气，23日下午，中国气象局召开高温天气新闻通气会。\n\n　　刚过6月就出现极端高温天，今年夏天还会有多少高温天呢？对此，国家气候中心首席预报员高辉表示，根据国家气候中心预计，今年夏天全国大部分地区气温都比常年同期要偏高，这也对应着高温日数也要高于常年同期。但不同的地区，高温集中时段不一样，比如南方地区是在盛夏时间段进入高温季，而北方地区往往是在初夏时间段，所以从今年夏季来说，要区分不同的地区来考虑高温的影响。\n\n　　我国各地高温集中时段有明显的地域差异。对华北地区来说，通常雨季前的6月至7月初更容易出现高温天气，连续数天的高温在6月也比较常见。高辉说，这段时间主要是干热型高温为主，表现为气温高湿度小。进入7月后期，随着副高北跳和夏季风往北推进，水汽输送和大气湿度增加，云量也会增多，会出现闷热天气，也就是湿热型高温。就最高气温而言，前一时段气温最高值通常高于后一时段。但也需要说明的是，人体体感温度不仅和气温有关，还受到湿度影响，往往这种湿热型高温会加重人体体感温度。', 1, 1, 0, '2023-06-25 09:31:00', '2023-06-25 09:31:00', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (4, '中央气象台发布今年首个高温橙色预警', '新华社北京6月22日电（记者黄垚）22日18时，中央气象台升级发布今年首个高温橙色预警。预计23日白天，华北、黄淮等地将继续出现35℃以上的高温天气，北京、天津、河北中南部、山东中北部等地部分地区最高气温可达40℃左右。\n\n　　气象监测显示，22日8时至16时，北京、天津、河北中部、山东北部等地气温上升迅猛，最高气温升至40℃以上。上述4省份共有17个国家气象观测站最高气温突破历史极值。', 1, 1, 0, '2023-06-25 09:31:36', '2023-06-25 09:31:36', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (5, '江南水乡 龙舟竞渡', '江南水乡 龙舟竞渡---6月18日，浙江省湖州市“我们的节日·端午”暨第七届江南·民当端午民俗文化旅游节在南浔区和孚镇民当村开幕，来自南浔区各个乡镇的农民选手在河道中赛龙舟、划菱桶，体验传统端午民俗。', 1, 1, 0, '2023-06-25 09:32:13', '2023-06-25 09:32:13', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (6, '螃蟹粽、印花蛋、艾草凉粉……你知道端午有哪些创意美食吗？', '端午有旅行路上的见闻，有诗画里的艺术，也少不了舌尖上的风韵。听风入夏粽香佐茶，您还知道端午有哪些创意美食吗？端午至味，总少不了粽子这一味。甜的、咸的，肉馅的、蛋黄的、红枣的、豆沙的……一起来寻味端午！\n\n　　古人其实早就喜欢把各种果干放进粽子里，美食家苏轼还发明了杨梅粽。《玉台新咏》中说，“酒中喜桃子，粽里觅杨梅。”后来苏轼曾借用过这个典故，在元祐三年所写的端午帖子中说，“不独盘中见卢橘，时于粽里得杨梅”。', 1, 1, 0, '2023-06-25 09:32:40', '2023-06-25 09:32:40', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (7, '尼克斯拒绝执行罗斯球队选项 罗斯成自由球员', '北京时间6月25日，据多方消息源报道，尼克斯拒绝执行德里克-罗斯下赛季的球队选项，罗斯成为完全自由球员。\n\n　　34岁的罗斯在刚刚结束的赛季队内角色严重下滑，他仅出战27场比赛，场均登场12.5分钟，得到5.6分1.5篮板1.7助攻。\n\n　　2021年，罗斯与尼克斯签下3年4300万美元的续约合同，其中最后一年为1560万美元球队选项。', 2, 2, 0, '2023-06-25 09:34:26', '2023-06-25 09:34:26', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (8, '班凯罗承诺代表美国男篮打世界杯 名单仅差1人', '北京时间6月25日，据著名NBA记者沙姆斯-查拉尼亚报道，魔术前锋保罗-班凯罗承诺将代表美国男篮参加2023年男篮世界杯。\n\n　　班凯罗在刚刚结束的赛季场均能够砍下20.0分6.9篮板3.7助攻，获得了NBA2022-23赛季年度最佳新秀。', 2, 2, 0, '2023-06-25 09:34:59', '2023-06-25 09:34:59', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (9, 'F1加拿大大奖赛正赛：维斯塔潘冠军 阿隆索亚军', '2023年F1加拿大大奖赛正式比赛结束。红牛车队维斯塔潘杆位发车一路轻松领跑，再次完成了Pole-to-Win！这是红牛车队历史上的第100座分站冠军！同时也是维斯塔潘F1生涯的第41座分站冠军，追平了“车神”埃尔顿·塞纳的冠军数！阿斯顿马丁车队阿隆索亚军，梅赛德斯车队汉密尔顿季军。', 2, 2, 0, '2023-06-25 09:35:43', '2023-06-25 09:35:43', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (10, 'CTCC绍兴柯桥站圆满落幕 张志强曹宏炜各取一冠', '6月24日，2023赛季CTCC中国汽车场地职业联赛绍兴柯桥站在雨中的浙江国际赛车场上演了两回合决赛的巅峰角逐。在线上线下观众的共同见证下，超级杯-TCR中国系列赛、运动杯-长三角赛车节联袂献上高水平对决，以精彩的比赛献礼这个端午节假期！TCR 中国系列赛第三回合于今天上午率先开战。来自壳牌捷凯领克车队的张志强穿云破雾夺得冠军；夺得该回合亚军的是驾驶新赛车出战的东风本田车手高度，季军则由Z.SPEED N车队的张臻东斩获。这也是超级杯四冠王本赛季首次登台。', 2, 2, 0, '2023-06-25 09:36:18', '2023-06-25 09:36:18', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (11, '国象联赛常规赛收兵：杭州银行第一 山东成功上岸', '6月17日，“武陵山大裂谷杯”中国国际象棋甲级联赛常规赛在武陵云海国际酒店进行了最后一轮的争夺，杭州银行弈和山东队，抢到常规赛的冠军；山东队也是凭借这场平局，成功脱离保级区。本轮最大的悬念是第八名的争夺——在年底进行的甲级联赛总决赛中，前八名为上半区争冠组，保级无忧；而第九至十二名为保级区，不仅夺冠无望，还要为保级而苦战。', 2, 2, 0, '2023-06-25 09:36:51', '2023-06-25 09:36:51', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (12, '围棋名宿解读高考作文:人生如棋 要先学会下“本手”', '今年高考开考了，在语文考试后，体育借势冲上了社交媒体的热搜榜。奥运相关话题进入高考，是意料之中。不过当记者看到关于围棋术语“本手、妙手和俗手”的作文命题时，着实觉得有些难。在被迅速刷屏的朋友圈里，记者感受到了很多从业者的激动、兴奋乃至油然而生的自豪感。但也有人则为那些没学过棋的孩子感到担心，这么难的题目，究竟该如何解题？\n\n　　“围棋正在深入人心。题目有些难，‘俗手’如何定义？但确实应该先下好‘本手’。”翻到中国围棋协会副主席、国家围棋队领队华学明的这条朋友圈动态时，记者瞬间觉得这道公认的难题有了解题的思路。正如高考作文材料中所说，本手是基础。只有持之以恒地打好基础，补强短板，守住不发生系统性风险的底线，才有可能在本手的基础上，下出妙手，避免俗手。而如果脱离了基础，所谓的妙手很可能就是花拳绣腿，经不起推敲，更经不起对手的冲击。世界冠军柯洁表示：“很多人在对局中经常会拘泥于局部，下出假妙手。想下出真正的妙手，必须在平日里有一定的经验积累和训练，才可能完成真正卓越的妙手。”人生如棋，棋如人生。“其实人生中大部分时间都是在下本手”，围棋名宿曹大元九段说。', 2, 2, 0, '2023-06-25 09:37:43', '2023-06-25 09:37:43', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (13, '不甘人后：被生成式AI弥漫的亚马逊', '今年早些时候，随着ChatGPT席卷全球，亚马逊的经理们要求员工开动脑筋，想想如何使用人工智能（AI）聊天机器人技术来改进自家产品和工作流程。\n\n　　其中一些想法被分享在一份名为《生成式AI——ChatGPT的影响和机会分析》的内部文件中。这份文件共列了ChatGPT和类似应用程序在亚马逊多个团队中的67个潜在应用案例。\n\n　　早在20世纪90年代，亚马逊就靠在网上卖书创造了互联网界首个真正的商业奇迹。\n\n　　随后，Kindle阅读器带来革命性体验，Alexa和Echo智能音箱又带来了语音计算，而AWS则创造了云计算行业，ChatGPT就运行在这个行业之上。\n\n　　但这次热潮中拿到先发优势的是同为科技大厂的微软。微软现在是OpenAI背后的金主，且还在忙着把ChatGPT的底层技术融进微软产品和服务中。', 4, 5, 0, '2023-06-25 09:40:20', '2023-06-25 09:40:20', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (14, '微创新超实用：米家旅行箱居然想到了这一点', '旅行说走就走，除非老板没安排。名义上是旅游，实则执行任务，对内讲“为公司负重前行”，对外称“带薪游山玩水”，一介打工人，两副扑克脸，个中苦乐谁人知！\n\n“差旅人”精明如我，随身携带更偏向实用。\n\n必备日用之外，能路上买的尽量不带，华而不实的东西，往包里多塞一个都算我输。行李箱尺寸自然也要浓缩到小巧但够装的20英寸，拉着轻松又顺手，常用小物件转移到背包，“轻装上战场”。', 4, 5, 0, '2023-06-25 09:41:04', '2023-06-25 09:41:04', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (15, '小鹏G6动态试驾：辅助驾驶很惊喜', '这次我们开着小鹏G6上了赛道，又体验了最新版本的高速NGP和城市NGP，小鹏，还顺便测了下充电速度，那么小鹏G6驾驶感受如何？辅助驾驶表现怎么样？', 4, 5, 0, '2023-06-25 09:42:07', '2023-06-25 09:42:07', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (16, '养车市场陷入低价内卷，“虎猫狗”还没等到春天', '今年“618”期间，汽车后市场的玩家们都打出了“低价牌”。比如途虎养车宣布推出“6.18全民养车季”活动，在此期间北京车主可享受“轮胎买一送一”以及多品牌轮胎降价促销的活动。\n\n　　与此同时，京东养车和天猫养车两大大厂玩家，在本次618期间也喊出了各自的营销口号。\n\n　　前者不仅喊出了“养车爱车立省不止30%”的口号，还推出了轮胎、保养买贵赔两倍、“轮胎免费装、三年无忧质保”、5公里无服务门店赔双倍安装费等举措；天猫养车的618活动，则覆盖了更大的零部件范围，比如推出了空调清洗、机油和轮胎更换等低价服务。\n\n　　这样看，在本次618期间，途虎养车、京东养车和天猫养车均贯彻着“以价换量”的战略，以至于让行业价格战一触即发。这些玩家会这样做，主要是为了与传统4S店、以及与彼此竞争，以便保证自身获得更多的市场份额。', 4, 5, 0, '2023-06-25 09:42:51', '2023-06-25 09:42:51', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (17, '微软股价历史新高 聊天机器人技术潜力显现', '周四，微软股价创下历史新高，成为今年继英伟达和苹果之后，又一家市值达到新高点的大型科技公司。这家软件巨头正致力于在其产品和服务中添加生成式人工智能功能，旨在全面改造其Office产品阵容，其中包括Excel、PowerPoint、Outlook和Word等。股价上涨3.2%，收于每股348.1美元，为2021年11月19日以来的最高收盘价。自今年初起，微软股价累计上涨了45%，市值增加约8006亿美元。微软持有OpenAI的大部分股份，这家初创公司凭借聊天机器人ChatGPT引发生成式人工智能的热潮。近几个月来，该工具广受欢迎，展示了聊天机器人技术所具有的巨大潜力。微软于今年1月宣布将再向OpenAI投资100亿美元。然而有报道称，微软与OpenAI之间既有合作，亦存竞争，这种特殊的双重关系导致了双方关系的紧张和潜在冲突。科技股如英伟达等同样受益于生成式人工智能技术的应用，各公司将此技术融入各自产品，进而推动相关芯片需求。英伟达股价今年已飙升192%，被视为最大赢家。', 4, 5, 0, '2023-06-25 09:43:48', '2023-06-25 09:43:48', 0);
INSERT INTO `news_headline` (hid,title,article,TYPE,publisher,page_views,create_time,update_time,is_deleted) VALUES (18, '再获11亿美元投资：蔚来“长期主义”的底气', '如果说全系降价3万是李斌的“阳谋”，那么蔚来ET5T的发布，则是李斌的又一次诚意之作。\n\n　　ET5T是蔚来首款售价下探到30万元以下的新车，作为ET5的姐妹车型，ET5T和ET5的双车合璧，得以在30万以下快速开疆辟土。\n\n　　这样的做法有迹可循：特斯拉曾经在Model Y上实践过，并大获成功。\n\n　　Model Y和Model 3共用平台，零部件复用率高达75%，研发成本骤降。尽管Model Y最初被用户吐槽是Model 3的放大版，但不置可否的是Model Y确实解决了用户对Model 3空间不足的槽点。\n\n　　不过，最为关键的还是Model Y的价格足够低，直接降低了特斯拉的购买门槛，给那些对价格敏感，本犹豫要不要多花四五万的消费者一个充足的理由。\n\n　　蔚来ET5T正在用一种经受了市场验证过的方式，直面与特斯拉的竞争。但同时，蔚来ET5T在智能化、空间表现、设计以及产品力上，都正在接近、超越特斯拉Model Y。\n\n　　蔚来ET5T，平替特斯拉Model Y？\n\n　　小家庭，预算30万左右，消费者到底会选哪款纯电动车？\n\n　　全球市场的反馈是，特斯拉Model Y ——一款紧凑型SUV。2022年，Model Y的全球销量为74.7万辆，其在中国的销量为31.5万台，约占其全球份额的42.2%。\n\n　　按照车型大小，SUV可以分为大型、中型、小型、紧凑型四大类。按照价位，SUV又可以分为实用型、经济型、中高档型、豪华型、超豪华型等。\n\n　　Model Y 在中高端SUV的细分市场中一骑绝尘，可以说是没有对手。因为无论是奔驰EQC、宝马iX3，还是国产的比亚迪唐EV等，和Model Y相比，都不能对其构成威胁。奔驰EQC、宝马iX3这两款车型都是“油改电”，算不上真正的电动车。而比亚迪的智能化能力，远及不特斯拉，座舱、智驾上的核心模块还来自于供应商方案，并非自研。\n\n　　雷峰网认为，此前，国内的自主品牌中只有蔚来的ES6能和Model Y一较高下。不过ES6的均价比Model Y高出一大截，二者入门版之间的价差大约在10万左右。但在蔚来推出ET5T后，局势必然会发生逆转。', 4, 5, 0, '2023-06-25 09:44:20', '2023-06-25 09:44:20', 0);

-- ----------------------------
-- Table structure for news_type
-- ----------------------------
DROP TABLE IF EXISTS `news_type`;
CREATE TABLE `news_type`  (
  `tid` INT NOT NULL AUTO_INCREMENT COMMENT '新闻类型id',
  `tname` VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '新闻类型描述',
  `version` INT DEFAULT 1 COMMENT '乐观锁',
  `is_deleted` INT DEFAULT 0 COMMENT '头条是否被删除 1 删除  0 未删除',
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of news_type
-- ----------------------------
INSERT INTO `news_type` (tid,tname) VALUES (1, '新闻');
INSERT INTO `news_type` (tid,tname) VALUES (2, '体育');
INSERT INTO `news_type` (tid,tname) VALUES (3, '娱乐');
INSERT INTO `news_type` (tid,tname) VALUES (4, '科技');
INSERT INTO `news_type` (tid,tname) VALUES (5, '其他');

-- ----------------------------
-- Table structure for news_user
-- ----------------------------
DROP TABLE IF EXISTS `news_user`;
CREATE TABLE `news_user`  (
  `uid` INT NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户登录名',
  `user_pwd` VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户登录密码密文',
  `nick_name` VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户昵称',
  `version` INT DEFAULT 1 COMMENT '乐观锁',
  `is_deleted` INT DEFAULT 0 COMMENT '头条是否被删除 1 删除  0 未删除',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `username_unique`(`username`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of news_user
-- ----------------------------
INSERT INTO `news_user` (uid,username,user_pwd,nick_name) VALUES (1, 'zhangsan', 'e10adc3949ba59abbe56e057f20f883e', '张三');
INSERT INTO `news_user` (uid,username,user_pwd,nick_name) VALUES (2, 'lisi', 'e10adc3949ba59abbe56e057f20f883e', '李四');
INSERT INTO `news_user` (uid,username,user_pwd,nick_name) VALUES (5, 'zhangxiaoming', 'e10adc3949ba59abbe56e057f20f883e', '张小明');
INSERT INTO `news_user` (uid,username,user_pwd,nick_name)VALUES (6, 'xiaohei', 'e10adc3949ba59abbe56e057f20f883e', '李小黑');

SET FOREIGN_KEY_CHECKS = 1;
