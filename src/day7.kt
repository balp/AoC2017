
class TreeNode<T>(value: T){
    var value:T = value
    var parent:TreeNode<T>? = null
    var children:MutableList<TreeNode<T>> = mutableListOf()

    fun addChild(node:TreeNode<T>){
        children.add(node)
        node.parent = this
    }

    override fun toString(): String {
        var s = "${value}"
        if (!children.isEmpty()) {
            s += " {" + children.map { it.toString() } + " }"
        }
        return s
    }

}


fun main(args: Array<String>) {
    val example = """pbga (66)
xhth (57)
ebii (61)
havc (66)
ktlj (57)
fwft (72) -> ktlj, cntj, xhth
qoyq (66)
padx (45) -> pbga, havc, qoyq
tknk (41) -> ugml, padx, fwft
jptl (61)
ugml (68) -> gyxo, ebii, jptl
gyxo (61)
cntj (57)"""
    val puzzle = """mmqyju (156) -> rjzvwv, noybkx
dvkug (90) -> tbjbz, gxnvl
meeiw (95)
iaibv (52)
ckddz (36)
yikfhvr (52)
phqiqi (92)
ywctcn (38)
boofr (332) -> aqiun, zilgfzu
zfusug (65)
yffcj (90) -> bbmmtud, bqbgocl, kgntkz, mmfwbku, asefoiu
velbwcl (432)
liori (107) -> fzcts, wgfbd
watknc (96)
wbpvo (77) -> dtdkt, ixhnyqi
mladbjo (27)
cimsvsq (69)
ugyjqg (10)
tmybiz (55)
ueheft (12)
awweagx (26)
zxiqpq (88)
atcrb (92)
ocauj (95)
ayqfub (306) -> drwyz, prssjgo
xbeau (76) -> xxshfpr, renhdd
tmicb (21)
uesefn (59)
kbcztr (82)
rcssnrj (89)
ruahai (23)
gjtfdc (27)
eknipd (695) -> lyqumu, egjriv, ipnwyh
cqlnevp (23)
svibl (384)
jjvdara (27)
kpnjwzl (79)
mhtgqj (333) -> jzyfyj, njbqsh
mhxpay (200) -> zffpdg, smhctr
cinjgkc (11)
nvpsm (135) -> yfjtfc, oebjoin, phmpasy
qxnfz (29)
smpoeov (79) -> wygaxkm, vjjhef
dckpb (64)
lgsulw (254) -> kmmtdma, luemof
sgjljt (23)
mjverr (15)
kbhig (38)
tvranal (153) -> oyegdcw, gjtfdc
dresa (218) -> grcpk, uqork
kixuhs (88) -> prjag, dnrtq, vltxhu, lupel
adooxhb (37)
esxbml (69)
skgciiy (23)
utnwfrl (55)
fixda (59)
jmwrcxe (88) -> hwvglh, rgiaar, dypjwz
radrzr (88)
gdbvvx (36)
rfowq (266) -> xztwenv, gdbvvx
qvily (7)
jvegmwc (153) -> mladbjo, jjvdara
qesuv (303) -> tculi, lsgvik, boofr
xhifoak (6)
zkhxn (52)
gjaltuo (54) -> gffoyh, mrzmkae
taaibzy (209) -> xbbygk, ysqizk
lzzeke (24) -> tfdwxe, kvgsfj, lwaoy
zspyg (57)
qvcnscn (21)
pkyos (67)
teduvz (61) -> watknc, ibvain
oppaock (53)
vrlcw (823) -> svibl, upxfo, kzxpedk
rmwhlgz (179) -> zjkdtrq, jpshwm, dytikd
qjpyu (191) -> ssnkl, cqakc, mentp
cxrjgg (25)
btmuz (154) -> pnxkdii, fxhtvj
ithtabv (50)
hjbghmi (45)
yxlqjxz (61)
huwrhd (92)
xgzmr (471) -> yiwuei, kdptwot, wjkdl, ialdmz, nqkbjlh, lkijuws
iebero (287) -> honhsr, cehuzkr
cqgqm (214) -> ryatef, khuyb, opluk
njiwy (19)
nqkbjlh (237) -> xhifoak, nkikn
wjaav (94)
gtmfflw (13) -> cnsemxt, tdmre, wqcyyp
gxfqm (9)
jccqeca (60) -> yxzvg, hsedh
jvmpc (180) -> oiuih, yeojp
gzogp (9) -> tzhjol, xwuvr, tjurw, fnecqcx, hovodbo, mjorwvu
phkhvmp (127) -> tmicb, kfnox, xuxtbe, qzflerr
jirvayi (84)
vsuyxah (68)
uzcfn (11)
jxuvy (128) -> nplxpml, wttkrli
ihmflgt (39)
efwsj (13)
ntdeykb (11)
kolxt (195) -> sctwwty, esxbml
viofo (72)
svugo (32) -> xolvnpy, gjxqx, gtzxxav, njorjq, qpiklvf
owjht (58)
sfjspc (41) -> jlzxun, gnweaxi, ftloq, xbqsegw
bmfcc (48) -> ixmsn, sdosxki, pmwsup
bqrvhzi (21)
yemke (49) -> hqdcn, jltou, fnjdau, lwemj, eathpcv, xwslnr
pmwzrxm (103) -> mumtfo, azokid, cueuqa
vnqxpf (30)
rkait (96)
rtsbu (120) -> isnkzg, ipmyklq
tmxbh (363)
jfctkmt (60)
ihsfpwk (19)
lhdgv (59)
syefk (45)
aglcugi (368) -> iaybgca, fekljc, pxhroue
mezpvo (47)
olaxe (36)
gpudbvp (33)
mrzmkae (91)
neoyxft (11)
rpdrdxo (77)
spxqd (24)
pjkrgv (64)
gcashr (16)
ohfpwd (42)
dvkjfk (310)
fzmzcc (137) -> rzgdz, bptimbu
nithd (47)
wttkrli (60)
kyoopc (167) -> ntdeykb, uzcfn
vyitr (23)
gggvdzp (65) -> fxjacfb, gxwqiat, trotdqj, ygvnuu
nikpljz (97)
xolvnpy (22946) -> dfbeg, ajrrm, niuzt
zkyvs (76)
qkyqkf (38)
wdprouh (69)
mtpicwi (162) -> lzkcsih, hlcpmj, lzllws
vdvwz (92)
nplxpml (60)
spagr (200) -> fkzarsq, awweagx
uezwbls (92)
wqmlfzf (98)
qubsj (176) -> agnkj, ewbgxj
rpijm (71) -> cjszhjz, cbihaff
udwhf (1047) -> kolxt, trwpih, oqhuqw, jggkrpf
oebjoin (18)
zhfpuu (88)
uyeeefd (55)
asckjlv (4889) -> majzil, mubtpc, wgufuoj, uxlfqru
uvokiil (18)
lybou (114) -> bsttxpj, ivbkm
pmutbr (18)
ipmyklq (28)
gjxqx (14) -> yruivis, rizjob, qsfwl, asckjlv, sfqwrge, bncdhrm
essizn (185) -> tdreqt, ycoeh
wcvuu (57)
wwdta (85) -> mdpdynj, fdvks, zyufjm
vjjvitk (30)
frgpbr (21)
vkvsku (59)
dcdgsj (81)
ursswr (50)
pasahyc (31) -> tvuey, yosexh
nstfuaj (82)
lbogwls (82)
zzsjca (15) -> sglbby, bkxbja
oxipms (2533) -> njfaf, okyya
oegjhcg (196) -> tbplngl, kcqxplp
qgwyq (292) -> odqodqo, tuuzkn
qqckql (88)
hnlec (30)
lwaoy (89)
pjcluy (32)
wgfbd (68)
rzqtfk (167) -> nggfesp, jmnzios, iecbxj, gijrym
kmmtdma (68)
jvkpk (14)
cedfch (94)
rbpdfud (138) -> wqmlfzf, meyihxo
rlcbfav (960) -> yqjtia, qycgu, jzpih
shscp (146) -> zjovf, rwjupwq
remft (188) -> yevgrf, mzvna
lwwovy (34)
douxy (391) -> ayqfub, pwgtgs, voqlc, xfcaona, inilfk
guaulxm (92)
fciapx (153) -> hnlec, xlvzg, yjxiv
bbozoqx (98)
rgicvct (57)
cyusmf (904) -> rhazko, imrtnt
ebyaofj (169) -> wudjb, uyjoabs
xkdkyxu (92)
sorhq (198)
ymetxqm (21)
cbihaff (19)
kuzim (130) -> vcbcy, mzozybe
gehri (45) -> uikxbgu, zotzrjn
ebvlur (31)
wormisx (75)
tcnrrg (83)
mdpwa (76)
honhsr (27)
qpiklvf (11870) -> weohqnq, oifwih, udamz
mjtsrs (153) -> pexdlf, sjrepyz
mcqnk (18)
zunzpwe (61)
hsedh (94)
blrgxsb (13)
khvwq (93)
zrprsn (370) -> tqwxt, eshhfd, jrqnj
gxlrkmy (93)
mmcebdy (37)
ovlnitv (6)
dkzlr (38)
hrjop (74) -> brtxkgi, vgdjxl
efcjat (78)
ymjmo (22)
gnweaxi (44)
fbplv (90)
ttldnhl (8265) -> qifwjr, qckol, qjpyu, cyusmf, aglcugi, bkkwt
mwkjo (206) -> kgfbft, eqlnvl, uihrkc
fuitrtz (89)
vpuxpxj (165) -> bkuxrk, lqxevih, eixwwxn
onrklke (20)
cirsfs (182) -> adckzt, ujgeo
emqnw (55)
ysseykl (88) -> noxvqga, pmlho, cdlnovn
yluell (270)
njfaf (69)
ydtqhd (174) -> fpmzgvo, ibasy, zoeam, bpboa
noybkx (21)
hkcuz (126) -> vefasv, cvbnb
jcjsn (15)
xxikrr (14)
jxcxf (14)
wleja (43)
oyegdcw (27)
lqdyln (78)
ngpkzb (92)
axsupxp (861) -> bpcxrn, jjhqu, fvtboh, emgpu
gnovsx (38)
kizgz (38)
leubrjl (41)
eflhino (370) -> qubsj, cqgqm, ftcizt, lkuphpg, tcndbu
xlvzg (30)
xbqsegw (44)
xbbygk (22)
rujpx (44)
inzafdy (23)
hnurp (294) -> aaspu, ncrzjm
cvbnb (32)
cxuzdyf (180) -> hvfav, lnund
xewgja (310)
muarank (260) -> yvzuohq, ecbpy
pucapcr (35)
tpldx (119) -> fyqftv, ttiemo, vjjvitk, xgzja
hnszth (13)
uajyksv (7) -> avlhpbs, ywzku
yuecj (6)
jdgbrz (79)
cofol (1327) -> zjkxmfh, xniyrk, bqzcmr, gjaltuo, oapztg
tkvcp (111) -> jpfbl, dmoexuj, vopoojk, blebnht
bbmmtud (186) -> qvcnscn, pomeveh, mflxo
lcggy (77)
dytikd (8)
tqwxt (5)
hthizhf (12)
zmfeb (96)
uaajucq (174) -> khuqo, onnwjy, nmpojs, jzhtpli
gppcfr (95)
oswptur (15)
tculi (344)
anvukkl (29)
zksug (25)
luemof (68)
onnwjy (15)
eqlnvl (44)
ywzku (91)
amulani (85) -> kedwhhj, stjjr
wxikdvk (29)
lkhbcfn (97)
cueuqa (69)
fzwdnl (139) -> thbbk, kmecjf, mjverr, oswptur
bpjtor (125) -> twcrr, ltiabeu, vlbxwof, lycxba
emszr (36)
lcxllj (59)
ihbeh (34)
qjqyd (48)
nggfesp (18)
ugres (102)
kkxxua (34)
hjwyc (28)
meygo (37)
twcrr (63)
trwpih (297) -> hghnmv, nzygm
sphbbz (1161) -> gioryg, scetry, sfjspc, ivpbt, vyufo, valbm, oprfjt
dzhvos (51) -> nithd, dleprko, hqvbm, bcmtnt
drxxrz (12)
igjcv (21)
ubwfyx (35)
xtuocx (42)
kepgi (7) -> ndfkl, lsxavn
ujgeo (24)
cjusyky (12)
ijlsc (35)
myhzuy (67)
fkzarsq (26)
tdmre (66)
xponr (68)
hrhwxq (23)
vhfqi (49)
dyhtgng (302) -> wngrd, covjpf, mosbw, ljvrj, jvegmwc, mptzfm
scetry (9) -> qvzlvq, eounj, iaibv, zkhxn
ivbkm (56)
rwjupwq (43)
sxppnu (4079) -> tisslxr, hqvoym, ahdgqpm, xpmraw, dghbo
zxpxr (35)
lnund (98)
bpcxrn (146) -> poslxf, ryclgvc, vgdjz
uxlfqru (643) -> mhxpay, taslihw, ttqrjz
bcmtnt (47)
iodopqk (610) -> zhffwjr, sykqu, btmuz, cirsfs
gbmobi (97)
xutqsde (18)
opyjeyu (79)
ydwug (112) -> fbplv, clvvt, pnyyag
aemufzz (246) -> tatyvy, rujpx
dkasko (86) -> nstfuaj, vmcib
xgytt (377)
zjurdqp (115) -> adooxhb, meygo
jpfbl (52)
ebjlbr (112)
rhazko (20)
ajrrm (7311) -> yemke, ugmfrt, crnvz
zrltc (183) -> jdenl, anvukkl, wxikdvk
urliam (69)
nwjosw (198) -> iilxm, cvmjs, jgzuz
mavpqd (367) -> ymetxqm, izdutmt, ptvkpk
vbsku (35)
ljvrj (183) -> drxxrz, ueheft
jrqnj (5)
biibrbq (6792) -> gzogp, udwhf, vfepai
escjt (82)
zokte (31)
psjyx (46)
ysqizk (22)
ihxtg (41)
jzpih (127) -> igjcv, gvbxg, umkwa
rqswk (189) -> ohfpwd, usdonaj
llsqcnz (23)
mosbw (21) -> tenewcj, losxko
ukvdvgo (78)
jlzxun (44)
wounsqk (99)
arsrlmc (66) -> putprdw, pgfgtwj
hxnea (302) -> gcashr, wwmta
pxhroue (98) -> diccfps, mezpvo
mmgep (155) -> yscvt, vdxvll
lsgvik (65) -> jgqxt, yztcfw, jmnxhqh
wjkdl (179) -> rwtyr, zxpxr
yfkfk (90) -> xvtvomy, pkktbxs
tucemlh (82)
zsvyve (2401) -> lokxju, oppaock
gvbxg (21)
izdutmt (21)
dutfal (59)
qqlkwr (59)
pmwsup (74)
xgzja (30)
epflhcq (314) -> pxqgvjs, ebvlur
snqyc (90)
jgzuz (13)
poslxf (73)
wfzkd (6)
kbcjy (81)
fnecqcx (231) -> yuerovj, kbcztr
wgmxwy (78) -> kysof, zrqkic, qytnj, qqvrhv
ezwrgwg (23)
fteop (38)
qimvddh (99) -> qjqyd, iyytgk, ppepf
lycxba (63)
cjszhjz (19)
nbksews (75) -> fpdttlv, ygjbwu, vlhrcsh, sdawsdp, lzzeke
sfqwrge (948) -> pdyhl, njzaj, uaztc, hpthw, xgzmr
upxfo (204) -> akqoae, fgihxex
wterb (93)
nxvhzm (75)
xrffbj (88)
jpshwm (8)
imnmqmc (1056) -> crghfz, rsygg, fpimfx, icurk, infjgg, drxkj
errywn (2003) -> jklwqzz, blzatj, uiqegu
bqgxg (14)
iollvjh (75)
bwtwoy (46)
khaneu (35) -> spuzkk, sheuujc
aaspu (41)
nzmzrf (63)
etgpwm (22)
kwilox (41) -> cedfch, wjaav
asefoiu (249)
sglbby (94)
mnchjf (65) -> cimsvsq, grmps
lzllws (90)
kvmxpmx (93)
ectqv (37) -> rmbnnq, fuvary
amauas (34)
gymdygg (26) -> zmpsuwb, wonxy, lqdyln, efcjat
tzespqz (56)
rkotan (72) -> gumtctd, snqyc
chtiq (89)
oflkits (88)
zjpzq (94) -> bskomwv, ythizc, pucapcr, ubwfyx
rbozm (214) -> qzxsz, qvily
otgvzj (194) -> sygrs, gxlrkmy
jzhtpli (15)
tfdwxe (89)
ialdmz (12) -> gznay, jdgbrz, tcvrov
dleprko (47)
kgfbft (44)
iyytgk (48)
jcjqr (99)
smlnw (376)
uqork (26)
hduix (55)
sbbpewr (64) -> nkohugb, qfrgkwt
njpyn (834) -> npqwie, sbbpewr, nvqjado
mhhfovk (1721) -> camcas, fzwdnl, ujacw
wmskqd (31)
bpboa (44)
udamz (45) -> sitbr, cofol, zsvyve, errywn, sizeg, thqkly, ccqhl
wfsovdl (47)
jzlmges (237)
dnacpie (61) -> ngadrj, gedohd, yuvmlq, klmedvh, aende, tkvcp
fdoszd (97)
ajkxrcl (71) -> ykbvkc, escjt, yolrl, kuoluj
kiqjb (89) -> whiwt, bdkcdaq
yqgwle (31)
wnykty (53)
kfnox (21)
khuyb (6)
fljico (212)
vzhdg (78)
qqqxi (88)
tmnklf (982) -> hxnea, wwdta, aemufzz, rbpdfud
axnnpf (73)
ijcvtep (41)
ihcolp (70)
vefasv (32)
pruqcvk (34)
agnkj (28)
fuxnvo (33) -> ngpkzb, xkdkyxu
ejqqxk (75)
afzkp (83)
prssjgo (13)
rzgdz (46)
pzxqe (139) -> zokte, wmskqd
cmgfqkb (48)
xwdlxg (178) -> qpfup, wnykty, vwlcnv, vjzph
sizeg (2371) -> lwwovy, amauas, krcdkw, kkxxua
lnhrx (258) -> isceom, bwtwoy
mentp (185) -> gpudbvp, ljvipn
njimb (15)
hxzqgfl (76)
giagung (52)
qzxsz (7)
egbjx (84)
zrqkic (28)
kzwcue (81)
iilxm (13)
qckol (416) -> mnkholz, hrobopm, rtsbu
tzhjol (278) -> ihmflgt, jvnks, iefgdb
ecbpy (85)
okyya (69)
aealnl (63)
gnetslx (58)
jvaqkq (56) -> xgytt, mkwoc, mtwvvup, cbodyg, llajkfm, bpjtor
mfgpyyw (47)
pohvscs (81)
nmawxdq (35)
xhtorci (46)
wajjyev (119) -> mmkbh, lcggy
bdovfqj (60)
klmedvh (319)
ercgkci (81)
vdcnit (214) -> zxiqpq, oflkits
vvqpt (66)
nqwkb (98)
hqdcn (205) -> wiwrw, jgnvooj, wtsgud
fbhzkoh (32) -> afzkp, knbeerh
sgygf (50)
aklxi (211) -> pvrocec, lstxl
dfbeg (77) -> dnacpie, xgjyuie, ygnxu, gpsaq, vrlcw, xnzmf, tongu
jltou (358)
ptvkpk (21)
camcas (129) -> qubakh, tromme
iunpq (1373) -> ruusx, hrjop, lybou
eounj (52)
oiuih (85)
uiakb (28)
imrtnt (20)
ylzdc (57)
chsgrkx (90)
vgdjz (73)
nnbcnzu (1184) -> pedrwzo, unkckgx, sklzg
bhgcvz (50)
wtioxkx (90) -> fgoqtbj, zunzpwe, yxlqjxz
fvtboh (68) -> hrwcuqh, wjccpg, wounsqk
thqkly (1735) -> krldk, gdndx, mmgep, qwrruob
cqcqid (21)
buaue (1110) -> arpzsz, ueyxaa, iowckgn
gwqvxp (38)
ukjzi (26)
jdooxot (158) -> zkbdn, tshems
vjxqtpi (95)
zyufjm (83)
vlhrcsh (139) -> gnovsx, zwpqdpp, qkyqkf, hhgrgoa
gftxf (79)
vywee (45)
wlrdp (58)
eebyw (84)
cafcfnl (19) -> ntnqvtk, uezwbls
ogltzt (12)
saifkw (11) -> rkait, srozw
ruusx (28) -> jcjqr, bchpnd
ndfkl (91)
brjpqy (168) -> zfusug, uagtgt, htzdq
zmpsuwb (78)
sklzg (63) -> wvrrwfs, kpnjwzl, gftxf, unrxrxg
mhmbmve (75)
jhztf (93)
rdiysu (18)
yuvmlq (229) -> cadkdj, syefk
scurl (906) -> oymgkey, otgvzj, dojoi
kdkng (23)
akqoae (90)
nigxeuz (18)
pwgtgs (194) -> ykiurcc, mapgeoe
vgdjxl (76)
sgbzm (108) -> wwutk, licetbw, nwjosw, jzlmges, qlfars, gggvdzp
julhx (72)
lfbbsay (63)
iaybgca (129) -> frgpbr, mvqoekw, vmebh
tunuzcn (17) -> nquzdn, qzohrj, rsmvde, thsdq
tbtzwz (153) -> wleja, pckcqy
vxrdwe (15)
fzuomz (27)
uyjoabs (37)
imcujsr (92) -> bdovfqj, tnmziio
bipgvd (173) -> nmawxdq, tbnuh
mubtpc (85) -> juifyyw, uxpblf, sqbnfxf
ghhfd (60)
noxvqga (98)
wwutk (127) -> mbxchx, tmybiz
njorjq (31504) -> ppgcgz, tdqqjpg, zuhfs, lyxqyl
tzypui (85)
oopqud (261) -> lxkwe, urvedm
rklqa (59) -> nwsecpl, xtnyr
pnyyag (90)
igaui (84)
thbbk (15)
unrxrxg (79)
gcdbb (74)
urgfd (48)
srwgf (31)
phmpasy (18)
kcqndc (60)
faendwk (83) -> kcqndc, jfctkmt
rizjob (6366) -> eknipd, mhhvcg, zparvpi
aaalewd (95)
mzymfht (22)
silwij (75)
xtnyr (90)
lxkwe (6)
nquzdn (46)
szyzmuw (28)
kkidtmk (13)
bxeil (81)
bsttxpj (56)
jhpiym (94)
zjkxmfh (236)
sultgf (90) -> uyeeefd, hduix, zrofm, zqdnix
hturdef (24)
jimcygz (75)
xlxroru (6)
nlirga (41)
ypxvo (40) -> nqwkb, bbozoqx, jvwlo, yktkkr
wudjb (37)
blebnht (52)
bkkwt (335) -> khaneu, zzsjca, rmwhlgz
pdqvd (64)
whiwt (64)
jiqrrq (35)
tbjbz (93)
pedrwzo (309) -> zwjdka, jiqrrq
zoeam (44)
rmqmme (97)
awfrk (25)
majzil (784) -> fzmzcc, bnawjt, kwilox
qsfwl (63) -> rlcbfav, iodopqk, njpyn, kwymyn, sgbzm, nbksews, eflhino
bnawjt (137) -> hrhwxq, ybtsie, inzafdy, ezwrgwg
usdonaj (42)
mjvxc (188) -> wyiofd, sgygf, ursswr
yefht (196) -> xutqsde, pmutbr
smhctr (38)
qsnwd (65) -> cxuzdyf, qtgxg, smlnw, hnurp, epflhcq, kixuhs
cjixx (241) -> wdprouh, urliam
zdtby (961) -> dtfayu, qfuqfre, yaqfv, fuxnvo, kiqjb
iovig (22)
zrofm (55)
dybapm (159) -> jtxkj, utnwfrl, cdzfql, emqnw
qtgxg (376)
oxpphmz (1319) -> uylmxqo, hufovxb, ugres
uzpxmf (198)
vchfk (23)
fvcbh (233) -> xsauoti, joruazf, ijlsc
xvmstn (64)
nvxbdd (6)
zauos (107) -> uniifn, xponr
yvzuohq (85)
kvqrdbr (15)
uikxbgu (97)
wgufuoj (667) -> ovzoej, pzxqe, pasahyc, tunuzcn
ecsdihr (93)
kyvqypb (16)
eathpcv (256) -> tugui, psdcdbm
iclrood (121) -> vyitr, qynklua, aahmp
uiycup (59)
ttiemo (30)
zhffwjr (89) -> casskdk, wfsovdl, umzrb
jddjjw (21) -> jvaqkq, mhhfovk, flsxmc, tmnklf, lazvv, cfxwzf
yvicgh (73)
hrwcuqh (99)
yypsdby (41)
sgnexg (96)
xxdnojb (92)
mbymo (81)
bwujye (83)
covjpf (61) -> qiediji, yvicgh
xxelf (34)
juihbkt (94)
gludbju (12)
oqhuqw (90) -> ercgkci, ogrpc, bxeil
bqzcmr (108) -> pjkrgv, rfooa
mumtfo (69)
dpbywy (49)
fpimfx (119) -> skgciiy, cqlnevp
ygnxu (160) -> bpctu, siykhg, aklxi, brjpqy, tmxbh
tcvrov (79)
zncyr (999) -> ezxakj, injvyeb, whboh
qzflerr (21)
enjhfeg (13)
eixwwxn (29)
ryatef (6)
bkxbja (94)
eeuykqk (47)
ivinyhh (6)
swshl (25)
mapgeoe (69)
jljjh (37)
fuvary (75)
njbqsh (33)
ztfziz (56) -> nikpljz, gbmobi
kikqp (97)
uwmpw (97)
hqvoym (1226) -> jccqeca, xbeau, jxuvy
isnkzg (28)
wsstaru (12)
edsdrz (59)
sqbnfxf (440) -> guuvcz, wniti
sviek (24)
cmdjxza (76)
putprdw (73)
dnrtq (72)
cuvpk (97)
qghnwdf (94) -> jirvayi, eebyw, igaui, nklype
gffoyh (91)
wumlot (221) -> neoyxft, cinjgkc
rfooa (64)
yevgrf (32)
pkuggs (131) -> fdplo, tzespqz
vaexiu (1581) -> ymjmo, iovig
rehpie (86) -> liori, zauos, ebyaofj, pbqrv, fciapx, bipgvd
vcumw (94)
uobgk (338) -> adygspa, psjyx
gtvsym (18)
wvrrwfs (79)
pckcqy (43)
qymuwz (74)
cfxwzf (1634) -> mlvywui, kuzim, rbozm
hrwhc (51) -> jhpiym, juihbkt
lazvv (1589) -> pkuggs, wumlot, qimvddh
ykbvkc (82)
tbplngl (18)
sjrepyz (60)
tdreqt (54)
jvlrpy (7)
zwrwngq (203)
valbm (65) -> cmdjxza, tzcosab
zfkfc (856) -> tbtzwz, dzhvos, tcewj, gehri, ixcueuk
qrncpfb (463) -> trrrswp, mjtsrs, ziiojfl
hsnkmd (77)
ttqrjz (86) -> ddmyid, gppcfr
lnddtya (60)
ghzfclb (929) -> aokguyj, shscp, zzjap
cvmjs (13)
tongu (778) -> ajkxrcl, hjsyte, mhtgqj
amwlt (102) -> putxfkb, edswm
ixcueuk (181) -> kgjzt, qxnfz
jvnks (39)
kzxpedk (72) -> udiibbj, izvxax, ymnqdi, ukvdvgo
jmnzios (18)
aglfaj (78)
qqfxsbl (56)
omivhf (24)
mkjdh (62) -> zksug, squxhq
ogilk (28)
drxkj (39) -> atjgje, lfbbsay
lcltlz (90) -> dmobhqz, lelwu
exyceo (81)
paguj (212) -> njiwy, ihsfpwk
odqodqo (70)
umzrb (47)
yosexh (85)
bchpnd (99)
wngrd (115) -> fpzvpx, xhtorci
hjlabl (56)
nrqmk (35)
kdptwot (195) -> gtvsym, svmplb, pnbyuu
injvyeb (112)
llajkfm (277) -> bhgcvz, cpjwxir
cbodyg (85) -> qvpit, jlonsf, axnnpf, fmdmn
dojoi (80) -> jimcygz, mhmbmve, wormisx, ejqqxk
tcewj (125) -> rgicvct, wcvuu
kvgsfj (89)
ythizc (35)
mnxqlwj (149) -> srwgf, pqhdp
cpjwxir (50)
iwvzne (85) -> silwij, ecilwqw, nxvhzm, iollvjh
nnpndet (54)
kuoluj (82)
fzcts (68)
xerinl (15)
mvacic (6) -> tqxwy, dckpb, dlksv
tisslxr (824) -> ysseykl, ydwug, zoawdu
fssxj (82) -> vgxptd, myhzuy, pkyos, rclvfez
yolrl (82)
ogrpc (81)
tzcosab (76)
vdbcedp (92)
flsxmc (2200) -> qqlkwr, knayoo
rfxjtuw (93)
njfzhmg (45)
howjlo (78)
wbftdq (85) -> dutfal, lcxllj
brtxkgi (76)
wspsxh (211)
ibasy (44)
whboh (88) -> fawih, hthizhf
weohqnq (6219) -> sibzbaw, gaijq, oxpphmz, cdbqrv, vaexiu, ghzfclb, dlgyd
svmplb (18)
nglzp (39)
sctwwty (69)
gdndx (193)
lgqhttl (323) -> hzmiprs, yqgwle
yktkkr (98)
zzjap (88) -> mpgup, zeohg
uylmxqo (38) -> pjcluy, bqpjwai
xxshfpr (86)
vgxptd (67)
kgpoyb (157) -> llowph, gnetslx
vspbcnk (236) -> fvyctke, nrqmk, vbsku
iowckgn (75)
zstxoet (85)
zjkdtrq (8)
ddmyid (95)
zeohg (72)
wwmta (16)
ewbgxj (28)
urvedm (6)
lkijuws (229) -> lqzhrg, ugyjqg
mzvna (32)
yiwuei (249)
htzdq (65)
tnmziio (60)
crghfz (37) -> pdqvd, xvmstn
llocrvp (9)
oprfjt (171) -> gbwuf, otipnbc
umkwa (21)
ustmeld (13)
pomeveh (21)
squxhq (25)
wbbus (72)
rclvfez (67)
hevef (37)
lsxavn (91)
bqzpg (90)
fdvks (83)
tatyvy (44)
hufovxb (54) -> spxqd, hturdef
wniti (11)
fxjacfb (43)
nmpojs (15)
lbmqte (298) -> zebtnox, ustmeld, kkidtmk, enjhfeg
cnsemxt (66)
izvxax (78)
cnafwov (93)
iefgdb (39)
ivpbt (217)
cdlnovn (98)
gxnvl (93)
ziiojfl (155) -> lhdgv, vkvsku
pnbyuu (18)
pnxkdii (38)
nlzqs (48)
mnkholz (54) -> ymfxsdp, lqdrs
cehuzkr (27)
lnfyg (95)
vmcib (82)
losxko (93)
mlvywui (30) -> zyeqj, kmrsi, vvqpt
czrbivk (29)
avufwe (59)
iecbxj (18)
mhxka (25)
xuxtbe (21)
skcmxwu (72)
pkmya (47)
qiediji (73)
gzldofv (32)
rgiaar (34)
vmcicx (94)
zwpqdpp (38)
qwrruob (133) -> jcjsn, xerinl, czzvje, njimb
lwemj (6) -> rgkzdr, qqqxi, uypwb, radrzr
oymgkey (354) -> blrgxsb, pfamjeh
tykkgvz (14) -> wterb, kvmxpmx, ecsdihr
zffpdg (38)
gznay (79)
yhbpsay (186) -> tcgjhh, leubrjl, ihxtg, ijcvtep
nvqjado (204) -> jvkpk, omzye
lstxl (76)
tshems (16)
zqdnix (55)
hefczgn (50) -> phqiqi, atcrb
uagtgt (65)
ssnkl (95) -> aglfaj, jtqcbjx
zyeqj (66)
pbqrv (75) -> qqfxsbl, jijzbp, gdvydrc
jbcaxyl (54)
otlvpiq (46) -> velbwcl, ypxvo, qgwyq, mtpicwi
krldk (97) -> akyffva, nlzqs
knayoo (59)
meyihxo (98)
zjovf (43)
opluk (6)
lqzhrg (10)
nnayovj (268) -> wxnwn, stpwv, gymdygg
revfs (62)
kssnbr (63) -> llsqcnz, kdkng
qfuqfre (217)
naheh (39)
jzyfyj (33)
rvzug (124) -> jbcaxyl, nnpndet
hdkyjhw (42)
xpmraw (1409) -> xulssc, ectqv, votqgct
llowph (58)
jmnxhqh (93)
ahdgqpm (833) -> dybapm, crlyq, cjixx
pqhdp (31)
kmecjf (15)
jggkrpf (309) -> yuecj, nvxbdd, xlxroru, wfzkd
fgihxex (90)
gaijq (675) -> jdooxot, hkcuz, wgmxwy, iclrood, jmwrcxe
yruivis (2760) -> oxipms, ggpau, sphbbz
dnomd (92)
dymsh (63)
ygjbwu (235) -> hbnjvi, uiakb
jmpqot (93)
lqdrs (61)
sitbr (57) -> fssxj, yhbpsay, jvmpc, lnhrx, ydtqhd, lbmqte, dmxqneb
nkikn (6)
trrrswp (95) -> rcssnrj, chtiq
qynklua (23)
jdenl (29)
qbvlzq (77)
yvpvvx (84)
huide (45)
cadkdj (45)
bcyxwt (62)
dlgyd (625) -> lzgjxpi, paguj, dkasko, pxkqb
atjgje (63)
uiqegu (6) -> gqzlx, pohvscs
wqcyyp (66)
evauuqp (23) -> rfowq, gwaym, mwkjo, fvcbh, mjvxc, bhcdq
irmrw (521) -> vspbcnk, iebero, eshrket
dtdkt (65)
mpgup (72)
ppepf (48)
kxegssv (22)
ljvipn (33)
azokid (69)
ovxnqnd (96) -> lgsulw, xwdlxg, vfkff, rsidt, vdcnit
gioryg (77) -> mldtvex, ihcolp
gdvydrc (56)
cunseqy (38)
itnut (161) -> flcth, hjlabl
psfpl (38)
hmkoeo (139) -> gzldofv, dteqv
kptyuf (74) -> opyjeyu, xqeqnpv
vdxvll (19)
kwymyn (702) -> dvkug, ndjbiq, kykqehq
unkckgx (201) -> fuitrtz, atbdhm
rfmuffd (132) -> fixda, uesefn
knbeerh (83)
sheuujc (84)
qlfars (161) -> dkzlr, kbhig
uaourd (48)
fmdmn (73)
wlauod (252)
ppgcgz (2965) -> dusyrs, bblhcmt, otlvpiq
nhhqfzk (38)
rabaw (68)
casskdk (47)
fekljc (24) -> yvpvvx, egbjx
kgjzt (29)
arpzsz (27) -> omivhf, sviek
vlbxwof (63)
zfzpy (28)
wtsgud (51)
thsdq (46)
kmrsi (66)
dmoexuj (52)
gxwqiat (43)
ndjbiq (276)
bqpjwai (32)
licetbw (145) -> ruahai, yzrlkj, vchfk, sgjljt
hzoqij (174) -> cjusyky, ogltzt
ltgylh (18)
xnzmf (1127) -> arsrlmc, fljico, imcujsr, soutui
jgqxt (93)
omzye (14)
yaeji (96)
lokxju (53)
mkwoc (377)
vjycok (33)
bblhcmt (1015) -> teduvz, mkcxutj, taaibzy
wzfzy (95)
yjxiv (30)
ixmsn (74)
vopoojk (52)
wzjwo (145) -> kxegssv, mzymfht, etgpwm
sdosxki (74)
lluca (96)
mflxo (21)
soutui (60) -> cunseqy, akunww, nhhqfzk, fteop
emgpu (217) -> jljjh, bawyt, mmcebdy, hevef
zuhfs (3655) -> irmrw, dyhtgng, rehpie
johqjt (26)
ygvnuu (43)
orozsek (78)
xsauoti (35)
ncrzjm (41)
pxqgvjs (31)
vcbcy (49)
bpctu (39) -> kfbxhd, dcdgsj, kzwcue, tuxmvw
vwtpihe (270)
qytnj (28)
gwaym (47) -> rmqmme, kikqp, lkhbcfn
wfkbot (92)
aqiun (6)
vfepai (2052) -> rpijm, smpoeov, kssnbr
ggpau (91) -> mavpqd, vtthqum, qghnwdf, uobgk, muarank, cgldm
mkcxutj (199) -> mcqnk, ltgylh, nigxeuz
nrbka (85) -> giagung, yikfhvr
kykqehq (90) -> khvwq, jmpqot
ccisqhk (36)
xvqpfd (81)
rgkzdr (88)
xulssc (7) -> vywee, njfzhmg, hjbghmi, huide
etrye (68) -> bwujye, tcnrrg
mptzfm (131) -> kauaro, gwqvxp
zilgfzu (6)
qvzlvq (52)
yscvt (19)
lqxevih (29)
tugui (51)
qzohrj (46)
oifwih (13748) -> qrncpfb, czwja, nnayovj
khuqo (15)
darha (47)
fvyctke (35)
egjriv (228) -> kvqrdbr, vxrdwe
mzozybe (49)
juifyyw (74) -> cuvpk, fdoszd, uwmpw, qqbjpw
mldtvex (70)
yuerovj (82)
qifwjr (65) -> tykkgvz, ghfsfzv, essizn
ftcizt (36) -> oieio, hzmzm
oapztg (14) -> awhtfnb, qymuwz, plfmb
renhdd (86)
yfjtfc (18)
qfrgkwt (84)
dmxqneb (65) -> vjxqtpi, ocauj, meeiw
akyffva (48)
iwvjsf (21)
mmkbh (77)
qvpit (73)
pexdlf (60)
wygaxkm (15)
sibzbaw (204) -> cafcfnl, faendwk, zwrwngq, mnchjf, saifkw, wbftdq, hmkoeo
ipnwyh (81) -> edsdrz, pqciwb, uiycup
bqbgocl (85) -> rtbipng, yypsdby, nlirga, bgprkt
mjorwvu (341) -> uvokiil, svcfwb, yqvqkjj
ngadrj (143) -> qqckql, xrffbj
putxfkb (5)
dmobhqz (81)
guuvcz (11)
pqciwb (59)
hovodbo (251) -> ibvrqj, oxshhlc
kysof (28)
hwvglh (34)
crlyq (51) -> zhpbfcb, vdmpy, lbogwls, tucemlh
mbxchx (55)
ymnqdi (78)
yxzvg (94)
stjjr (52)
bgprkt (41)
pnvym (58)
fyxeenq (25)
eshhfd (5)
adygspa (46)
zhpbfcb (82)
mhhvcg (83) -> sorhq, hzoqij, mvacic, fbhzkoh, uzpxmf, cmyrw, mmqyju
vwlcnv (53)
ifylycs (78)
hrobopm (136) -> tzupdgb, onrklke
vgxaajp (88)
lgowj (58)
uypwb (88)
ghfsfzv (293)
otipnbc (23)
gwlzolt (50)
rtlvfb (74)
pvrocec (76)
vdmpy (82)
grmps (69)
jvwlo (98)
stpwv (238) -> fyxeenq, mhxka, awfrk, cxrjgg
gboqva (31) -> chsgrkx, bqzpg
hpthw (805) -> oegjhcg, iriepoo, rvzug, kptyuf, yefht
rsygg (81) -> xtuocx, hdkyjhw
vfkff (336) -> fzuomz, xbgyvu
nklype (84)
oieio (98)
fpzvpx (46)
dndusk (349) -> pzpybas, rdiysu
njzaj (40) -> lgqhttl, zrprsn, iwvzne, ohixl, dndusk
eeucvf (58)
jlonsf (73)
tuuzkn (70)
zoawdu (94) -> ongsjaf, zmfeb, sgnexg
xwslnr (210) -> rtlvfb, gcdbb
kfbxhd (81)
plfmb (74)
ixhnyqi (65)
jjhqu (365)
pzxhsq (25)
bkuxrk (29)
fnjdau (222) -> vsuyxah, rabaw
qycgu (96) -> mfgpyyw, darha
ccqhl (1886) -> tvranal, cjzstd, wbpvo
ohixl (353) -> kyvqypb, boqtus
tuxmvw (81)
ycoeh (54)
prjag (72)
hvfav (98)
tvuey (85)
gpsaq (1408) -> amulani, kepgi, kyoopc
aende (88) -> hsnkmd, qbvlzq, rpdrdxo
lupel (72)
hqvbm (47)
sygrs (93)
gbwuf (23)
wyiofd (50)
yzrlkj (23)
tjurw (23) -> rfxjtuw, zujwuu, jhztf, cnafwov
zwjdka (35)
kcqxplp (18)
gtzxxav (8936) -> sxppnu, jddjjw, biibrbq, ttldnhl
hpboonp (33)
cdzfql (55)
infjgg (109) -> szyzmuw, zfzpy
nkohugb (84)
eemxdkb (76)
dusyrs (1024) -> ztfziz, pxpuiaz, rfmuffd
nwsecpl (90)
sdawsdp (6) -> aaalewd, wzfzy, lnfyg
dypjwz (34)
aahmp (23)
grcpk (26)
zujwuu (93)
wiwrw (51)
cgldm (406) -> gludbju, wsstaru
kedwhhj (52)
rsidt (66) -> xvqpfd, kbcjy, exyceo, mbymo
tcndbu (96) -> ihbeh, flyaq, pruqcvk, xxelf
srozw (96)
tcgjhh (41)
rtbipng (41)
lyqumu (84) -> pnvym, owjht, eeucvf
aokguyj (88) -> skcmxwu, viofo
hjgfxun (29)
ezxakj (112)
svcfwb (18)
yaqfv (217)
hzmzm (98)
lyxqyl (2947) -> yffcj, zncyr, buaue, qesuv
uxpblf (214) -> ehttqe, cleda, revfs, bcyxwt
ehttqe (62)
dghbo (59) -> itnut, oopqud, gmtkf, kgpoyb, wtioxkx, wajjyev, rqswk
ntnqvtk (92)
yeojp (85)
gmtkf (126) -> pmjoye, dpbywy, vhfqi
fpmzgvo (44)
rsmvde (46)
hghnmv (18)
lkuphpg (48) -> dnomd, vdvwz
inilfk (282) -> swshl, pzxhsq
ftloq (44)
hbsdlm (26)
lelwu (81)
qqvrhv (28)
czwja (87) -> fqhegd, rzqtfk, tpldx, hrwhc, rklqa
tenewcj (93)
iriepoo (88) -> wbbus, julhx
flyaq (34)
jtxkj (55)
kauaro (38)
dteqv (32)
ibvain (96)
isceom (46)
fpdttlv (249) -> iwvjsf, bqrvhzi
ibvrqj (72)
avlhpbs (91)
zotzrjn (97)
vjzph (53)
edswm (5)
bhcdq (62) -> vdbcedp, xxdnojb, wfkbot
hhgrgoa (38)
yqvqkjj (18)
mdpdynj (83)
dtfayu (217)
gedohd (263) -> ogilk, hjwyc
uihrkc (44)
bskomwv (35)
lzgjxpi (66) -> huwrhd, guaulxm
kihst (30)
npqwie (56) -> vgxaajp, zhfpuu
jijzbp (56)
wonxy (78)
hjsyte (207) -> urgfd, mfdpgv, uaourd, cmgfqkb
vmebh (21)
ueyxaa (57) -> gxfqm, llocrvp
hzmiprs (31)
mvqoekw (21)
mmfwbku (60) -> dymsh, nzmzrf, aealnl
ltiabeu (63)
uniifn (68)
trotdqj (43)
pdyhl (699) -> wzjwo, phkhvmp, gboqva, mnxqlwj, gtmfflw, wspsxh
uaztc (1629) -> amwlt, mkjdh, ebjlbr
pmlho (98)
zparvpi (713) -> zjurdqp, uajyksv, nrbka, nvpsm
yztcfw (93)
eshrket (53) -> lluca, zntrxf, yaeji
flcth (56)
spuzkk (84)
kgntkz (149) -> gwlzolt, ithtabv
xvtvomy (81)
ratsida (38)
ybtsie (23)
qpfup (53)
ovzoej (129) -> emszr, olaxe
tdqqjpg (83) -> evauuqp, iunpq, douxy, zfkfc
akunww (38)
rjzvwv (21)
rwtyr (35)
bptimbu (46)
vyufo (65) -> eemxdkb, mdpwa
jgnvooj (51)
tbnuh (35)
siykhg (287) -> kizgz, ratsida
wjccpg (99)
qqbjpw (97)
zntrxf (96)
fgoqtbj (61)
bawyt (37)
voqlc (104) -> rmilbmd, hxzqgfl, zkyvs
rmbnnq (75)
fyqftv (30)
xztwenv (36)
votqgct (187)
diccfps (47)
fawih (12)
czzvje (15)
ujacw (91) -> ckddz, ccisqhk, yedpzj
lzkcsih (90)
fdplo (56)
xniyrk (194) -> npkqzzg, cqcqid
vtthqum (312) -> syxaall, avufwe
hbnjvi (28)
rmilbmd (76)
oxshhlc (72)
sykqu (230)
joruazf (35)
syxaall (59)
wzqcv (58)
xwuvr (207) -> vmcicx, vcumw
niuzt (5718) -> zdtby, imnmqmc, scurl, ovxnqnd
wxnwn (312) -> efwsj, hnszth
xgjyuie (211) -> wlauod, rkotan, lcltlz, yfkfk, vpuxpxj, remft, spagr
cdbqrv (75) -> xewgja, dvkjfk, oxpmdnr, sultgf, pmwzrxm
mfdpgv (48)
gumtctd (90)
adckzt (24)
dlksv (64)
npkqzzg (21)
yqjtia (148) -> xxikrr, jxcxf, bqgxg
zebtnox (13)
ecilwqw (75)
vjjhef (15)
pgfgtwj (73)
tqxwy (64)
xqeqnpv (79)
krcdkw (34)
cjzstd (113) -> pkmya, eeuykqk
nzygm (18)
crnvz (1261) -> etrye, zjpzq, uaajucq, hefczgn
udiibbj (78)
bncdhrm (3810) -> nnbcnzu, qsnwd, axsupxp
xfcaona (20) -> orozsek, vzhdg, ifylycs, howjlo
atbdhm (89)
drwyz (13)
ryclgvc (73)
fxhtvj (38)
fqhegd (65) -> lgowj, wlrdp, wzqcv
blzatj (154) -> zodnkd, jvlrpy
ongsjaf (96)
cqakc (131) -> lnddtya, ghhfd
yedpzj (36)
taslihw (198) -> nglzp, naheh
pxkqb (80) -> zstxoet, tzypui
zkbdn (16)
pkktbxs (81)
jklwqzz (90) -> hbsdlm, johqjt, ukjzi
mtwvvup (301) -> psfpl, ywctcn
xbgyvu (27)
clvvt (90)
ugmfrt (307) -> vwtpihe, sohtd, yluell, zrltc, bmfcc, dresa, httspr
cmyrw (138) -> vnqxpf, kihst
sohtd (156) -> zspyg, ylzdc
httspr (212) -> czrbivk, hjgfxun
bdkcdaq (64)
awhtfnb (74)
pxpuiaz (250)
ymfxsdp (61)
pmjoye (49)
zodnkd (7)
psdcdbm (51)
gijrym (18)
boqtus (16)
pfamjeh (13)
jtqcbjx (78)
cleda (62)
vltxhu (72)
qubakh (35)
ykiurcc (69)
tzupdgb (20)
hlcpmj (90)
tromme (35)
gqzlx (81)
icurk (153) -> ovlnitv, ivinyhh
oxpmdnr (244) -> hpboonp, vjycok
pzpybas (18)"""

//    println("** root: " + findRoot(buildTree(example)))
//    println("** root: " + findRoot(buildTree(puzzle)))

    val exampleTree = findRoot2(buildTree2(example))
    println("** root: " + toWeightString(exampleTree))
    findUnbalance(exampleTree, 0)
    // val tree = findRoot2(buildTree2(puzzle))
    // println("** root: " + toWeightString(tree))
    // findUnbalance(tree,0)

}

fun findUnbalance(tree: TreeNode<Pair<String, Int>>, depth: Int) {
    // println(tree.value.first)
    
    if (!tree.children.isEmpty()) {
        for (c in tree.children) {
            val message = c.value.first + ":" + treeWeight(c)
            println("".padStart(depth, '-') + message)
            findUnbalance(c, depth+2)
        }
    }
}

fun treeWeight(tree: TreeNode<Pair<String, Int>>) : Int {
    var w = tree.value.second
    if (!tree.children.isEmpty()) {
        w += tree.children.sumBy { it.value.second }
    }
    return w
}

fun toWeightString(tree: TreeNode<Pair<String,Int>>): String {
    var s = "${tree.value.first} (${treeWeight(tree)})"
    if (!tree.children.isEmpty()) {
        s += " {" + tree.children.map { toWeightString(it) } + " }"
    }
    return s
}

private fun findRoot(node: TreeNode<String>): TreeNode<String> {
    var root = node
    println("root: " + root)
    while (root.parent != null) {
        println("move root:" + root)
        root = root.parent!!
    }
    return root
}

private fun buildTree(input: String) : TreeNode<String> {
    val allNodes: MutableList<TreeNode<String>> = mutableListOf()
    val nodeMatch = "(\\w+)\\s\\((\\d+)\\)\\s->\\s(.*)".toRegex()
    val leafMatch = "(\\w+)\\s\\((\\d+)\\)".toRegex()
    for (line in input.lines()) {
        if (nodeMatch.matches(line)) {
            // println("node")
            val matches = nodeMatch.matchEntire(line)
            // println(matches?.groupValues)
            val name = matches?.groups?.get(1)?.value
            val number = matches?.groups?.get(2)?.value
            val children = matches?.groups?.get(3)?.value
            // println(name + ":" + number + ":" + children)
            allNodes.add(TreeNode(name!!))
        } else if (leafMatch.matches(line)){
            println("leaf")
            val matches = leafMatch.matchEntire(line)
            println(matches?.groupValues)
            val name = matches?.groups?.get(1)?.value
            val number = matches?.groups?.get(2)?.value
            println(name + ":" + number)
            allNodes.add(TreeNode(name!!))
        }
    }
    var root:TreeNode<String>? = null
    println(allNodes)
    for (line in input.lines()) {
        if (nodeMatch.matches(line)) {
            val matches = nodeMatch.matchEntire(line)
            println(matches?.groupValues)
            val name = matches?.groups?.get(1)?.value
            val number = matches?.groups?.get(2)?.value
            val children = matches?.groups?.get(3)?.value

            val node = allNodes.find { it.value == name }
            if (node != null) {
                println("to " + node + " add children " + children!!)
                if (root == null) {
                    println("initial root")
                    root = node
                }
                for (childname in children.split(",\\s+".toRegex())) {
                    val child = allNodes.find { it.value == childname }
                    if (child != null) {
                        println("to " + node + " add child " + child)
                        node.addChild(child)
                        if (root == child) {
                            root = node
                            println("make root")
                        }
                    }
                }
            }
        }
    }
    println(allNodes)
    println(root)
    return root!!
}

private fun findRoot2(node: TreeNode<Pair<String,Int>>): TreeNode<Pair<String,Int>> {
    var root = node
    println("root: " + root)
    while (root.parent != null) {
        println("move root:" + root)
        root = root.parent!!
    }
    return root
}
private fun buildTree2(input: String) : TreeNode<Pair<String,Int>> {
    val allNodes: MutableList<TreeNode<Pair<String,Int>>> = mutableListOf()
    val nodeMatch = "(\\w+)\\s\\((\\d+)\\)\\s->\\s(.*)".toRegex()
    val leafMatch = "(\\w+)\\s\\((\\d+)\\)".toRegex()
    for (line in input.lines()) {
        if (nodeMatch.matches(line)) {
            // println("node")
            val matches = nodeMatch.matchEntire(line)
            // println(matches?.groupValues)
            val name = matches?.groups?.get(1)?.value
            val number = matches?.groups?.get(2)?.value
            val children = matches?.groups?.get(3)?.value
            // println(name + ":" + number + ":" + children)
            allNodes.add(TreeNode(Pair(name!!,number!!.toInt())))
        } else if (leafMatch.matches(line)){
            println("leaf")
            val matches = leafMatch.matchEntire(line)
            println(matches?.groupValues)
            val name = matches?.groups?.get(1)?.value
            val number = matches?.groups?.get(2)?.value
            println(name + ":" + number)
            allNodes.add(TreeNode(Pair(name!!,number!!.toInt())))
        }
    }
    var root:TreeNode<Pair<String,Int>>? = null
    println(allNodes)
    for (line in input.lines()) {
        if (nodeMatch.matches(line)) {
            val matches = nodeMatch.matchEntire(line)
            println(matches?.groupValues)
            val name = matches?.groups?.get(1)?.value
            val number = matches?.groups?.get(2)?.value
            val children = matches?.groups?.get(3)?.value

            val node = allNodes.find { it.value.first == name }
            if (node != null) {
                println("to " + node + " add children " + children!!)
                if (root == null) {
                    println("initial root")
                    root = node
                }
                for (childname in children.split(",\\s+".toRegex())) {
                    val child = allNodes.find { it.value.first == childname }
                    if (child != null) {
                        println("to " + node + " add child " + child)
                        node.addChild(child)
                        if (root == child) {
                            root = node
                            println("make root")
                        }
                    }
                }
            }
        }
    }
    println(allNodes)
    println(root)
    return root!!
}