(window.webpackJsonp=window.webpackJsonp||[]).push([[42],{RNiq:function(e,t,n){"use strict";n.r(t);var a=n("pbKT"),r=n.n(a),i=n("ln6h"),o=n.n(i),c=n("O40h"),s=n("0iUn"),l=n("sLSF"),u=n("Tit0"),m=n("MI3g"),p=n("a7VT"),d=n("q1tI"),h=n.n(d),g=n("m/Pd"),b=n.n(g),f=n("nOHt"),k=n("fCdl"),v=n("CafY"),w=n("kOwS"),y=n("zrwo"),O=n("AT/M"),x=n("vYYK"),j=n("/MKj"),_=n("udWi"),I=n("QQ8+"),F=n("rtJH"),T=n("b1aS"),N=n("gT7Y"),A=n("dwco"),S=n("fadw"),B=n("xQtg"),C=n("eVfy"),U=n("ewr0"),L=n("Xp8U"),R=n("W6RO"),D=n("YVwf"),H=n.n(D),G=h.a.createElement;function M(e){var t=function(){if("undefined"===typeof Reflect||!r.a)return!1;if(r.a.sham)return!1;if("function"===typeof Proxy)return!0;try{return Boolean.prototype.valueOf.call(r()(Boolean,[],function(){})),!0}catch(e){return!1}}();return function(){var n,a=Object(p.a)(e);if(t){var i=Object(p.a)(this).constructor;n=r()(a,arguments,i)}else n=a.apply(this,arguments);return Object(m.a)(this,n)}}var V=Object(F.V)(),q=function(e){Object(u.a)(n,e);var t=M(n);function n(e){var a;return Object(s.a)(this,n),a=t.call(this,e),Object(x.a)(Object(O.a)(a),"state",{moreStatus:!0,page:2,limit:50,cardHeight:null,bannerHeight:null,trackingArray:[],loading:!1}),Object(x.a)(Object(O.a)(a),"homeFeedMore",function(){a.setState(Object(y.a)({},a.state,{loading:!0}));var e={page:a.state.page,limit:a.state.limit};Object(I.a)(e).then(function(e){200===e.status&&"success"===e.message&&(a.props.onHomeFeed(e.data.homeFeedData.list,null,e.data.homeFeedData.data.featuredFeedType),a.setState(function(t){return Object(y.a)({},t,{moreStatus:!(10===t.page||50!==e.data.homeFeedData.count),page:t.page+1})}))}).catch(function(e){console.log(e)}).finally(function(){return a.setState(Object(y.a)({},a.state,{loading:!1}))})}),Object(x.a)(Object(O.a)(a),"onBannerClick",function(e){var t=a.props,n=t.onTrackingAdClick,r=t.auth,i=t.userAgent,o=+new Date;n({a:Number(e.adGroupIdx),b:Number(e.adGroupBannerIdx),s:"home",t:o});var c=r.authStatus?r.user.idx:null;Object(T.g)(i,"banner_click","rolling",e.linkUrl,e.imageUrl,"home_main",null,null,c,e.adGroupBannerIdx,e.adGroupIdx)}),Object(x.a)(Object(O.a)(a),"onSwiperImages",function(e){return e.map(function(e,t){return G("div",{className:"swiper-slide",key:t},-1!==e.linkUrl.indexOf("hellomarket://hellomarket.api/")?G(_.Link,{route:e.linkUrl.replace("hellomarket://hellomarket.api","")},G("a",{onClick:function(){return a.onBannerClick(e)}},G("img",{src:Object(F.v)(e.imageUrl),className:"main_img",alt:"\ud648\ud53c\ub4dc \ubc30\ub108 \uc774\ubbf8\uc9c0 ".concat(t+1)}))):G("a",{href:e.linkUrl,target:"_blank",rel:"noopener noreferrer",onClick:function(){return a.onBannerClick(e)}},G("img",{src:Object(F.v)(e.imageUrl),className:"main_img",alt:"\ud648\ud53c\ub4dc \ubc30\ub108 \uc774\ubbf8\uc9c0 ".concat(t+1)})))})}),Object(x.a)(Object(O.a)(a),"onAdTracking",function(e){var t=a.props.onTrackingAdView,n=+new Date;t({a:Number(e.adGroupIdx),b:Number(e.adGroupBannerIdx),s:"home",t:n})}),Object(x.a)(Object(O.a)(a),"ItemComponent",function(e,t){var n=a.state.cardHeight,r=a.props,i=r.userAgent,o=r.imageUrl,c={root:"#scrolling-container",rootMargin:"pc"===i?"-60% 0px -25%":"-55% 0px -25%"};return G(S.a,Object(w.a)({},c,{key:e,onChange:function(e){return a.handleIntersection(e,t)}}),G("li",{className:"main_col_4",key:e,style:{height:n?"".concat(n,"px"):"auto"}},G(B.a,{itemList:t,imageUrl:o,type:"home",itemIndex:e,page:1,limit:1,userAgent:i})))}),a.handleIntersection=a.handleIntersection.bind(Object(O.a)(a)),a.swiper=null,a.deviceType=null,a.clientWidth=null,a}return Object(l.a)(n,[{key:"componentDidMount",value:function(){var e=this.props,t=e.core,n=e.auth,a=e.userAgent;this.deviceType=Object(F.p)(),this.clientWidth=document.body.clientWidth;var r=0;if(this.setState(function(){return{page:t.homeFeedsPage}}),"pc"!==a){var i=(document.body.clientWidth-5)/2*768/580;r=document.body.clientWidth/2.86,this.setState({cardHeight:i,bannerHeight:r})}else r=200,this.setState({bannerHeight:r});if(t.homeFeedBanner.length&&document.documentElement.scrollTop<r){var o=t.homeFeedBanner[0];this.onAdTracking(o);var c=n.authStatus?n.user.idx:null;Object(T.h)(a,"banner_exposure","rolling",o.linkUrl,o.imageUrl,"home_main",null,null,c,o.adGroupBannerIdx,o.adGroupIdx)}}},{key:"componentDidUpdate",value:function(e){e.core!==this.props.core&&Object(N.b)("img")}},{key:"handleIntersection",value:function(e,t){if(e.isIntersecting&&"item"===t.type){var n=this.props.onTrackingView,a=-1!==t.item.linkUrl.indexOf("/auto")?"".concat(t.item.linkUrl.replace("hellomarket://hellomarket.api/item/auto/","")):-1!==t.item.linkUrl.indexOf("/rc")?"".concat(t.item.linkUrl.replace("hellomarket://hellomarket.api/item/rc/","")):"".concat(t.item.linkUrl.replace("hellomarket://hellomarket.api/item/","")),r=+new Date;n({i:Number(a),s:"home",t:r})}else if(e.isIntersecting&&"ad"===t.type){var i=t.ad.list,o=void 0===i?[]:i;o.length&&this.onAdTracking(o[0])}}},{key:"render",value:function(){var e=this,t=this.props,n=t.userAgent,a=t.naverCheck,r=t.core,i=this.state,o=i.moreStatus,c=i.loading,s={pagination:{el:".swiper-pagination.home_banner_pagination",clickable:!0,dynamicBullets:!0,type:"pc"!==n?"fraction":"bullets"},navigation:{nextEl:".swiper-button-next",prevEl:".swiper-button-prev"},centeredSlides:!0,autoplay:{delay:3e3,disableOnInteraction:!1},renderPrevButton:function(){return G("div",{className:"swiper-button-prev"},G("svg",{xmlns:"https://www.w3.org/2000/svg",viewBox:"0 0 27 44"},G("path",{d:"M0,22L22,0l2.1,2.1L4.2,22l19.9,19.9L22,44L0,22L0,22L0,22z"})))},renderNextButton:function(){return G("div",{className:"swiper-button-next"},G("svg",{xmlns:"https://www.w3.org/2000/svg",viewBox:"0 0 27 44"},G("path",{d:"M27,22L27,22L5,44l-2.1-2.1L22.8,22L2.9,2.1L5,0L27,22L27,22z"})))},on:{slideChange:function(){if(document.documentElement.scrollTop<e.state.bannerHeight){var t=r.homeFeedBanner[e.swiper.realIndex],a=e.props.auth.authStatus?e.props.auth.user.idx:null;Object(T.h)(n,"banner_exposure","rolling",t.linkUrl,t.imageUrl,"home_main",null,null,a,t.adGroupBannerIdx,t.adGroupIdx),e.onAdTracking(t)}}}};"pc"===n&&(s.width=990);var l=0,u={list:r.homeFeedsList,moreStatus:o,homeFeedMore:this.homeFeedMore,ulStyle:"",loading:c};return G("section",{className:"content"},G("h2",null,"\uba54\uc778 \uc774\ubbf8\uc9c0 \uc601\uc5ed"),r.homeFeedBanner.length?G("div",{className:"banner_main_bg"},G("div",{className:"banner_main_promotion"},G("div",{className:"swiper-container banner_main_swipper"},G("div",{className:"swiper-wrapper"},G(H.a,Object(w.a)({},s,{ref:function(t){t&&(e.swiper=t.swiper)}}),this.onSwiperImages(r.homeFeedBanner)))))):null,G("div",{className:"main_area"},G("div",{className:"main_area_center"},G("div",{className:"main_home"},G("h1",null,U.seo.title),G("h2",null,U.seo.brief_description),G(C.a,{refs:u},r.homeFeedsList&&r.homeFeedsList.length&&r.homeFeedsList.map(function(t,a){return"pc"===n&&0!==a&&l%14===0?(l+=2,G(d.Fragment,{key:a},G("li",{className:"google_ads_native_main"},G(R.a,{slot:{location:"homefeed",type:"pcNativeType"},format:"fluid"})),e.ItemComponent(a,t))):(l++,G(h.a.Fragment,{key:a},e.ItemComponent(a,t)))})),"pc"===this.deviceType&&this.clientWidth>800&&!a?G(h.a.Fragment,null,G("div",{className:"login_banner_absolute",style:{top:r.homeFeedBanner.length?"-209px":"20px"}},G("div",{className:"login_banner"},G(R.a,{slot:{location:"homefeed",type:"mainBanner"},style:{width:"160px",height:"600px",display:"inline-block"}}),G("div",{className:"coupang main"},G("a",{href:"https://coupa.ng/bGBngI",target:"_blank",rel:"noopener noreferrer"},G("img",{style:{width:160},src:"https://ads-partners.coupang.com/banners/270683?subId=Webhomeside&traceId=V0-301-50c6c2b97fba9aee-I270683&w=200&h=200",alt:"\ucfe0\ud321\uad11\uace0 \ubc30\ub108\uc774\ubbf8\uc9c0"}))))),G("div",{className:"ad_banner_absolute",style:{top:r.homeFeedBanner.length?"-209px":"20px"}},G("div",{className:"ad_banner"},G("a",{href:"".concat(F.r,"/home-ad/content.html"),target:"_blank",rel:"noopener noreferrer"},G("img",{src:"".concat(V,"/web/2019/banner/img_banner_main_ad_0903_x2.png"),alt:"\ud648 \uad11\uace0 \ubc30\ub108 \uc774\ubbf8\uc9c0"}))))):null))))}}]),n}(h.a.Component),E=Object(j.b)(function(e){return{core:e.core,auth:e.auth,tracking:e.tracking}},function(e){return{onHomeFeed:function(t,n,a){return e(L.coreSetHomefeed(t,n,a))},onTrackingView:function(t){return e(L.trackingSetImpressionItem(t))},onTrackingAdView:function(t){return e(L.trackingSetImpressionAd(t))},onTrackingAdClick:function(t){return e(L.trackingSetClickAd(t))},onTrackingViewReset:function(){return e(L.trackingResetImpressionItem())},onTrackingClickReset:function(){return e(L.trackingResetClickItem())},onTrackingViewAdReset:function(){return e(L.trackingResetImpressionAd())},onTrackingClickAdReset:function(){return e(L.trackingResetClickAd())}}})(Object(A.a)()(q)),P=n("s5Js"),W=n("s4NR"),Y=n.n(W),z=n("aIN1"),J=n("m6Ax"),K=h.a.createElement;function Q(e){var t=function(){if("undefined"===typeof Reflect||!r.a)return!1;if(r.a.sham)return!1;if("function"===typeof Proxy)return!0;try{return Boolean.prototype.valueOf.call(r()(Boolean,[],function(){})),!0}catch(e){return!1}}();return function(){var n,a=Object(p.a)(e);if(t){var i=Object(p.a)(this).constructor;n=r()(a,arguments,i)}else n=a.apply(this,arguments);return Object(m.a)(this,n)}}var X=Object(F.V)(),Z=function(e){Object(u.a)(n,e);var t=Q(n);function n(){return Object(s.a)(this,n),t.apply(this,arguments)}return Object(l.a)(n,[{key:"render",value:function(){var e=this.props,t=e.isServer,n=e.userAgent,a=e.notice,r=e.userAgentType,i=!(!r||-1===r.indexOf("Yeti"));return K(h.a.Fragment,null,K(b.a,null,K("link",{rel:"canonical",href:"https://www.hellomarket.com/"})),K(k.a,{title:U.seo.title,keywords:U.seo.keywords,description:U.seo.description,url:"https://www.hellomarket.com/",imageUrl:"".concat(X,"/web/common/img_share_20170111.png"),type:"website"}),K(P.a,null),K(v.a,{location:!0}),a?null:K(E,{imageUrl:X,isServer:t,userAgent:n,naverCheck:i}),K("script",{type:"application/ld+json",dangerouslySetInnerHTML:{__html:'\n            {\n              "@context": "http://schema.org/",\n              "@type": "Organization",\n              "name": "\ud5ec\ub85c\ub9c8\ucf13",\n              "url": "https://www.hellomarket.com",\n              "sameAs": [\n                "https://www.instagram.com/hellomarket_story/",\n                "http://post.naver.com/my.nhn?memberNo=5135191",\n                "https://www.facebook.com/hellomarket",\n                "http://story.kakao.com/ch/hellomarketapp",\n                "https://twitter.com/HelloMarket",\n                "https://itunes.apple.com/kr/app/id469381475",\n                "https://play.google.com/store/apps/details?id=com.tuck.hellomarket"\n              ]\n            }'}}),K(z.a,null))}}],[{key:"getInitialProps",value:function(){var e=Object(c.a)(o.a.mark(function e(t){var n,a,r,i,c,s,l,u,m,p;return o.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:if(n=t.ctx,i=n.isServer,e.prev=2,!i){e.next=21;break}return c={page:1,limit:50},s=Y.a.stringify(c),e.next=8,fetch("".concat(F.b,"/api/feature/feeds?").concat(s),{credentials:"include",method:"GET",headers:n.req.headers});case 8:return l=e.sent,e.next=11,l.json();case 11:if(200!==(u=e.sent).status||"success"!==u.message){e.next=16;break}n.store.dispatch({type:J.y,homeFeedlist:u.data.homeFeedData.list,homeFeedBanner:u.data.advertiseBannerData.list,homeFeedType:u.data.homeFeedData.data.featuredFeedType}),e.next=17;break;case 16:return e.abrupt("return",{notice:u.message});case 17:a=Object(F.n)(n.req.headers["user-agent"]),r=n.req.headers["user-agent"],e.next=35;break;case 21:if(a=Object(F.n)(navigator.userAgent),r=navigator.userAgent,m=n.store.getState(),m.core.homeFeedsList.length){e.next=35;break}return n.query.page=1,n.query.limit=50,e.next=29,Object(I.a)(n.query);case 29:if(200!==(p=e.sent).status||"success"!==p.message){e.next=34;break}n.store.dispatch({type:J.y,homeFeedlist:p.data.homeFeedData.list,homeFeedBanner:p.data.advertiseBannerData.list,homeFeedType:p.data.homeFeedData.data.featuredFeedType}),e.next=35;break;case 34:return e.abrupt("return",{notice:p.message});case 35:return e.abrupt("return",{isServer:i,userAgent:a,userAgentType:r});case 38:return e.prev=38,e.t0=e.catch(2),e.abrupt("return",{isServer:i,userAgent:a});case 41:case"end":return e.stop()}},e,null,[[2,38]])}));return function(t){return e.apply(this,arguments)}}()}]),n}(h.a.Component);t.default=Object(f.withRouter)(Object(N.a)({Page:Z}))},vlRD:function(e,t,n){(window.__NEXT_P=window.__NEXT_P||[]).push(["/",function(){var e=n("RNiq");return{page:e.default||e}}])}},[["vlRD",1,0]]]);
