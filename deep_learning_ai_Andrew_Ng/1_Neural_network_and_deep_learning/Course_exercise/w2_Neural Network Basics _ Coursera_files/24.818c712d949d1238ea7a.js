(window.webpackJsonp=window.webpackJsonp||[]).push([[24],{"1j9p":function(module,e,a){"use strict";var t=a("VbXa"),n=a.n(t),r=a("UAeG"),s=a("sbe7"),o=a.n(s),i=a("VYij"),c=a.n(i),u=a("D/RE"),l=a("iF9W"),m=a("IDuc"),p=a("UZuA"),d=a("XVpT"),g=a("q3BH"),f=a("8cuT"),b=a.n(f),N=a("RnpQ"),v=a.n(N),y=function(e){function InboxNotificationsList(){for(var a,t=arguments.length,n=new Array(t),r=0;r<t;r++)n[r]=arguments[r];return(a=e.call.apply(e,[this].concat(n))||this).isValidMessage=function(e){return!!e.parsedData},a.renderMessage=function(e,a){return o.a.createElement(u.a,{key:e.id,id:e.id,createdAt:e.createdAt,data:e.parsedData,truncate:a,isRead:e.isRead,campaignId:e.campaignId})},a.renderFull=function(e){return a.renderMessage(e,!1)},a.renderTruncated=function(e){return a.renderMessage(e,!0)},a}var a;return n()(InboxNotificationsList,e),InboxNotificationsList.prototype.render=function render(){var e=this.props,a=e.naptime,t=e.messages,n=e.getMoreMessages,r=a.getPagingFor("messages"),s=c()(t).filter(this.isValidMessage),i=s.length,u=t.length-i,d=i<r.total-u,g=s.splice(0,1);return o.a.createElement(p.a,{trackingName:"render_page",className:"rc-NotificationsList",trackClicks:!1,requireFullyVisible:!1,withVisibilityTracking:!0},!i&&o.a.createElement(l.a,null),i>0&&this.renderFull(g[0]),i>1&&s.map(this.renderTruncated),d&&o.a.createElement(m.a,{trackingName:"show_more_messages",className:"secondary fullbleed",onClick:n},v()("Show more messages")))},InboxNotificationsList}(o.a.Component),h=g.a.createTrackedContainer(function(){return{namespace:{page:"course_inbox"}}})(y);e.a=c.a.compose(b()(["CourseStore"],function(e){var a;return{courseId:e.CourseStore.getCourseId()}}),r.a.createContainer(function(e){var a=e.courseId,t=e.maxNumberOfMessages;return{messages:d.a.getAll({fields:["layoutType","data","createdAt","isRead"],params:{q:"latest",courseId:a,setTime:!0,start:0,limit:t}})}}))(h)},"3ncW":function(module,exports,e){},"7Zkq":function(module,exports,e){},"D/RE":function(module,e,a){"use strict";var t=a("VbXa"),n=a.n(t),r=a("wiyT"),s=a.n(r),o=a("wd/R"),i=a.n(o),c=a("sbe7"),u=a.n(c),l=a("DnuM"),m=a("c6na"),p=a.n(m),d=a("Akn8"),g=a("0WYP"),f=a("9A5E"),b=a("c8Vh"),N=a("RhsD"),v=a.n(N),y=a("+9K8"),h=Object(l.a)("",{type:"rest"}),x=d.a.join(p.a.url.assets,"bundles/page/assets/white-logo-on-blue-bg.png"),E={width:100,auto:"format,compress"},M=function(e){function InboxNotification(){return e.apply(this,arguments)||this}n()(InboxNotification,e);var a=InboxNotification.prototype;return a.componentDidMount=function componentDidMount(){var e=this.props,a=e.id,t;e.isRead||s()(h.post("/api/siteMessages.v1?action=markAsRead&id="+a))},a.render=function render(){var e=this.props,a=e.createdAt,t=e.data,n=e.truncate,r=e.campaignId,s=t.imageUrl?g.a.processImage(t.imageUrl,E):x,o={backgroundImage:"url(".concat(s,")")},c=280;return u.a.createElement(b.a,{className:"rc-InboxNotification",isInitiallyCollapsed:n,gradientColor:"grey",showToggle:t.message.length>280},u.a.createElement("div",{className:"headline-container"},u.a.createElement("div",{className:"notif-img-container"},u.a.createElement("div",{style:o,className:"notif-img"})),u.a.createElement("div",{className:"subject"},t.subject),u.a.createElement("div",{className:"date color-secondary-text"},i()(a).fromNow())),u.a.createElement("div",{className:"message-text"},t.message),t.actionUrl&&t.actionText&&u.a.createElement(f.a,{href:t.actionUrl,trackingName:"course_inbox_".concat(r)},t.actionText))},InboxNotification}(u.a.Component);e.a=Object(y.a)(M)},GI63:function(module,exports,e){var a=e("7Zkq"),t;"string"==typeof a&&(a=[[module.i,a,""]]);var n={transform:void 0},r=e("aET+")(a,n);a.locals&&(module.exports=a.locals)},RhsD:function(module,exports,e){var a=e("y/rd"),t;"string"==typeof a&&(a=[[module.i,a,""]]);var n={transform:void 0},r=e("aET+")(a,n);a.locals&&(module.exports=a.locals)},"X/Eq":function(module,e,a){"use strict";a.r(e);var t=a("VbXa"),n=a.n(t),r=a("sbe7"),s=a.n(r),o=a("Z5ml"),i=a("1j9p"),c=a("QsJ7"),u=a("ZLWr"),l=a.n(u),m=a("GI63"),p=a.n(m),d=20,g=function(e){function CourseInboxPage(){for(var a,t=arguments.length,n=new Array(t),r=0;r<t;r++)n[r]=arguments[r];return(a=e.call.apply(e,[this].concat(n))||this).state={maxNumberOfMessages:d},a.getMoreMessages=function(){var e=a.state.maxNumberOfMessages;a.setState({maxNumberOfMessages:e+d})},a}var a;return n()(CourseInboxPage,e),CourseInboxPage.prototype.render=function render(){var e=this.state.maxNumberOfMessages;return s.a.createElement("div",{className:"rc-CourseInboxPage"},s.a.createElement(c.a,{pageTitle:l()("Course Inbox")}),s.a.createElement(o.a,null),s.a.createElement(i.a,{maxNumberOfMessages:e,getMoreMessages:this.getMoreMessages}))},CourseInboxPage}(s.a.Component);e.default=g},XVpT:function(module,e,a){"use strict";var t=a("W8MJ"),n=a.n(t),r=a("VbXa"),s=a.n(r),o=a("U+yc"),i=a.n(o),c=a("SYcQ"),u=a("HlCP"),l,m,p,d,g=(l=Object(c.b)("data"),d=p=function(e){function SiteMessage(){return e.apply(this,arguments)||this}return s()(SiteMessage,e),n()(SiteMessage,[{key:"parsedData",get:function get(){try{return JSON.parse(this.data)}catch(e){return null}}}]),SiteMessage}(u.a),p.RESOURCE_NAME="siteMessages.v1",m=d,i()(m.prototype,"parsedData",[l],Object.getOwnPropertyDescriptor(m.prototype,"parsedData"),m.prototype),m);e.a=g},Z5ml:function(module,e,a){"use strict";var t=a("VbXa"),n=a.n(t),r=a("w/1P"),s=a.n(r),o=a("17x9"),i=a.n(o),c=a("sbe7"),u=a.n(c),l=a("b+bd"),m=a("Q8V+"),p=a("kvW3"),d=a("37kS"),g=a.n(d),f=a("ilR0"),b=a.n(f),N=function(e){function CourseNameHeader(){return e.apply(this,arguments)||this}var a;return n()(CourseNameHeader,e),CourseNameHeader.prototype.render=function render(){var e=s()("course-name","color-primary-text",{"display-3-text":!Object(m.b)(),"display-2-text":Object(m.b)()});return u.a.createElement("div",{className:"rc-CourseNameHeader vertical-box align-items-absolute-center styleguide"},u.a.createElement("h2",{className:e},this.props.courseName),u.a.createElement("div",{className:"headline-1-text partner-names"},u.a.createElement("span",{className:"body-1-text"},u.a.createElement(p.b,{message:g()("by {partnerNames}"),partnerNames:this.props.partnerNames}))))},CourseNameHeader}(u.a.Component);N.propTypes={courseName:i.a.string.isRequired,partnerNames:i.a.string.isRequired},e.a=Object(l.a)(N,["CourseStore"],function(e,a){var t,n=e.CourseStore.getMetadata();return{courseName:n.get("name"),partnerNames:n.get("universities").getNamesString()}})},djZh:function(module,exports,e){},iF9W:function(module,e,a){"use strict";var t=a("VbXa"),n=a.n(t),r=a("sbe7"),s=a.n(r),o=a("Akn8"),i=a("c6na"),c=a.n(i),u=a("RnpQ"),l=a.n(u),m=a("oZQW"),p=a.n(m),d=o.a.join(c.a.url.assets,"images/course-inbox/no_messages.svg"),g=function(e){function EmptyInboxMessage(){return e.apply(this,arguments)||this}var a;return n()(EmptyInboxMessage,e),EmptyInboxMessage.prototype.render=function render(){return s.a.createElement("div",{className:"rc-EmptyInboxMessage"},s.a.createElement("div",{className:"imageContainer"},s.a.createElement("img",{src:d,alt:l()("No messages")})),l()("There are no messages yet."))},EmptyInboxMessage}(s.a.Component);e.a=g},ilR0:function(module,exports,e){var a=e("3ncW"),t;"string"==typeof a&&(a=[[module.i,a,""]]);var n={transform:void 0},r=e("aET+")(a,n);a.locals&&(module.exports=a.locals)},oZQW:function(module,exports,e){var a=e("djZh"),t;"string"==typeof a&&(a=[[module.i,a,""]]);var n={transform:void 0},r=e("aET+")(a,n);a.locals&&(module.exports=a.locals)},"y/rd":function(module,exports,e){}}]);
//# sourceMappingURL=24.818c712d949d1238ea7a.js.map