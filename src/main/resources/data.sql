﻿insert into public.tds_info(id,name,today,my_recommendatation,halt_flag,genre,area) values 
    (1,'ohayou',0,0,0,null,null)
  , (41,'インディ・ジョーンズ・アドベンチャー：クリスタルスカルの魔宮',0,0,0,1,4)
  , (42,'ディズニーシー・トランジットスチーマーライン',0,0,0,1,4)
  , (43,'レイジングスピリッツ',0,0,0,1,4)
  , (44,'ハンガーステージ',0,0,0,2,4)
  , (45,'”サルードス・アミーゴス！”グリーティングドック',0,0,0,3,4)
  , (46,'ミッキー＆フレンズ・グリーティングトレイル',0,0,0,3,4)
  , (47,'エクスペディション・フォトアーカイヴ',0,0,0,4,4)
  , (48,'ペドラーズ・アウトポスト',0,0,0,4,4)
  , (49,'ルックアウト・トレーダー',0,0,0,4,4)
  , (71,'海底2万マイル',0,0,0,1,7)
  , (72,'センター・オブ・ジ・アース',0,0,0,1,7)
  , (73,'ノーチラスギフト',0,0,0,4,7)
  , (74,'ヴォルケイニア・レストラン',0,0,0,5,7)
  , (75,'ノーチラスギャレー',0,0,0,5,7)
  , (76,'リフレッシュメント・ステーション',0,0,0,6,7)
  , (81,'ファンタジースプリングス・ギフト',0,0,0,4,8)
  , (82,'スプリングス・トレジャー',0,0,0,4,8)
  , (83,'ピーターパンのネバーランドアドベンチャー',0,0,0,1,8)
  , (84,'フェアリー・ティンカーベルのビジーバギー',0,0,0,1,8)
  , (85,'ルックアウト・クックアウト',0,0,0,6,8)
  , (86,'アナとエルサのフローズンジャーニー',0,0,0,1,8)
  , (87,'アレンデール・ロイヤルバンケット',0,0,0,6,8)
  , (88,'オーケンのオーケーフード',0,0,0,5,8)
  , (89,'ラプンツェルのランタンフェスティバル',0,0,0,1,8)
  , (410,'ロストリバーアウトフィッター',0,0,0,4,4)
  , (411,'エクスペディション・イート',0,0,0,5,4)
  , (412,'トロピック・アルズ',0,0,0,5,4)
  , (413,'ミゲルズ・エルドラド・キャンティーナ',0,0,0,6,4)
  , (414,'ユカタン・ベースキャンプ・グリル',0,0,0,6,4)
  , (415,'ロストリバークックハウス',0,0,0,5,4)
  , (810,'スナグリーダックリング',0,0,0,6,8);
  
  ﻿insert into public.genre(num,disp_name,name) values 
    (1,'アトラクション','attraction')
  , (2,'エンターテイメント施設','entertainment')
  , (3,'キャラクターグリーティング施設','greeting')
  , (4,'ショップ','shop')
  , (5,'レストラン','restaurant')
  , (6,'レストラン(MO対応)','mo')
  , (7,'レストラン(PS対象)','ps')
  , (8,'ポップコーンワゴン','popcorn')
  , (9,'そのほか施設','others');

  ﻿insert into public.area(num,disp_name,name) values 
    (1,'メディテレーニアンハーバー','MH')
  , (2,'アメリカンウォーターフロント','AF')
  , (3,'ポートディスカバリー','PD')
  , (4,'ロストリバーデルタ','LD')
  , (5,'アラビアンコースト','AC')
  , (6,'マーメイドラグーン','ML')
  , (7,'ミステリアスアイランド','MI')
  , (8,'ファンタジースプリングス','FS');
  
