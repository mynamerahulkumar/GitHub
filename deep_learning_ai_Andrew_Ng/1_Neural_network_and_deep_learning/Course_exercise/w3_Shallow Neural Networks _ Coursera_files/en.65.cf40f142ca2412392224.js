(window.webpackJsonp=window.webpackJsonp||[]).push([[65,63],{"++C6":function(module,e,t){"use strict";t.d(e,"a",function(){return a});var n=t("KMW/"),a=function isPostQuizHelpEnabled(e){var t;return!!n.a.get("postAssessmentHelp","postQuizHelp",{course_id:e})}},"+tyo":function(module,exports,e){var t=e("oKlG"),n=t.default?t.default:{},a,r=(0,e("HdzH").default)(n);r.getLocale=function(){return"en"},module.exports=r},"2jzc":function(module,e,t){"use strict";t.d(e,"a",function(){return o}),t.d(e,"g",function(){return u}),t.d(e,"d",function(){return f}),t.d(e,"c",function(){return v}),t.d(e,"b",function(){return p}),t.d(e,"f",function(){return S}),t.d(e,"e",function(){return I});var n=t("MVZn"),a=t.n(n),r=t("+tyo"),i=t.n(r),s=t("XC/k"),o;!function(e){e.Beginner="Beginner",e.Intermediate="Intermediate",e.Advanced="Advanced"}(o||(o={}));var u={Beginner:30,Intermediate:70,Advanced:100},l={Beginner:"#FFC500",Intermediate:"#3BAFDA",Advanced:"#33C68A"},c={Beginner:"#DBA900",Intermediate:"#258FB6",Advanced:"#006F43"},m=function getSkillPrimaryColor(e){return l[e]},d=function getSkillSecondaryColor(e){return c[e]},f=function getSkillLevel(e){return e<u.Beginner?o.Beginner:e<u.Intermediate?o.Intermediate:e<=u.Advanced?o.Advanced:o.Beginner},v=function getImprovingSkills(e){return e&&e.filter(function(e){return e&&e.isPredicted})},p=function getFormattedImprovingSkillNames(e){if(!e)return"";var t=e.reduce(function(e,t){var n=t&&t.competency&&t.competency.name;return e.push(n),e},[]),n;return t.reduce(function(e,n,a){var r=e;if(1===t.length)return n;return a===t.length-1?r+="and ".concat(n):t.length>2?r+="".concat(n,", "):r+="".concat(n," "),r},"")},b=function getSkillCompetencyHistories(e){return e.reduce(function(e,t){if(null===t)return e;var n=t.id,r=t.scores,i={};return i[n]=r,a()({},e,i)},{})},g=function getSkillCompetencyNextSteps(e){return e.reduce(function(e,t){if(null===t)return e;var n=t.id,r=t.steps,i={};return i[n]=r,a()({},e,i)},{})},S=function getTranslatedSkillLevel(e){var t;return{Beginner:i()("Beginner"),Intermediate:i()("Intermediate"),Advanced:i()("Advanced")}[e]},I=function getSkillProfileLink(){if(Object(s.a)())return"/skills";return}},"454o":function(module,exports,e){},"4oCI":function(module,exports,e){var t=e("bHVB"),n;"string"==typeof t&&(t=[[module.i,t,""]]);var a={transform:void 0},r=e("aET+")(t,a);t.locals&&(module.exports=t.locals)},A9kd:function(module,e,t){"use strict";var n=t("sbe7"),a=t.n(n),r=t("TOZ3"),i=t("m10x"),s=t("2jzc"),o=t("iY+7"),u=t("flPG"),l=t.n(u),c=function SkillScore(e){var t=e.name,n=e.readableScore,u=e.showName,l=void 0!==u&&u,c=e.children,m=Object(s.d)(n);return a.a.createElement(r.b,{rootClassName:"rc-SkillScore",flexDirection:"column",alignItems:"center",justifyContent:"center"},l&&a.a.createElement("div",null,t),a.a.createElement(i.b,null,n),a.a.createElement(i.g,{rootClassName:"level m-b-1"},Object(s.f)(m)),c&&a.a.cloneElement(c,{}),a.a.createElement(o.a,{readableScore:n,skillLevel:m}))};e.a=c},L2S7:function(module,e,t){"use strict";var n=t("VkAN"),a=t.n(n),r=t("sbe7"),i=t.n(r),s=t("lTCR"),o=t.n(s),u=t("oJmH"),l=t.n(u),c=t("TOZ3"),m=t("BxDD"),d=t("CsdX"),f=t("Q9IO"),v=t("9A5E"),p=t("sQ/U"),b=t("PDuk"),g=t.n(b),S=t("2jzc"),I=t("A9kd"),k=t("xanp"),y=t("kvW3"),E=t("+tyo"),h=t.n(E),D=t("4oCI"),C=t.n(D);function _templateObject(){var e=a()(["\n  query SkillsPostAssessmentQuery($userId: String!, $courseItemId: String!) {\n    SimpleCompetencyScoresV1 @naptime {\n      byUserAndCourseItemId(userId: $userId, courseItemId: $courseItemId) {\n        elements {\n          id\n          readableScore\n          competency {\n            id\n            name\n          }\n          lastAttemptAt\n          isPredicted\n        }\n      }\n    }\n  }\n"]);return _templateObject=function _templateObject(){return e},e}var A=o()(_templateObject()),N=function SkillsPostAssessmentNotification(e){var t=e.courseId,n=e.itemId,a=e.onDismiss;return i.a.createElement(u.Query,{query:A,variables:{userId:p.a.get().id.toString(),courseItemId:Object(b.tupleToStringKey)([t,n])}},function(e){var t=e.data;if(t&&t.SimpleCompetencyScoresV1&&t.SimpleCompetencyScoresV1.byUserAndCourseItemId&&t.SimpleCompetencyScoresV1.byUserAndCourseItemId.elements){var n=t.SimpleCompetencyScoresV1.byUserAndCourseItemId.elements,r=Object(S.c)(n);if(0===r.length)return null;var s=Object(S.b)(r);return i.a.createElement(c.b,{rootClassName:"rc-SkillsPostAssessmentNotification"},i.a.createElement(c.b,{flexDirection:"column"},i.a.createElement("strong",{className:"header-line-text"},i.a.createElement(y.b,{message:h()("Your skill {skillsCount, plural, =1 {score is} other {scores are}} improving!"),skillsCount:r.length})),i.a.createElement(c.b,{rootClassName:"description-text"},i.a.createElement(y.b,{message:h()("You've made progress in {skillNames}."),skillNames:s})," ",i.a.createElement(v.a,{trackingName:"view_skill_progress",target:"_blank nooppener noreferrer",href:Object(S.e)()},h()("View Skill Tracking."))),i.a.createElement(c.b,{rootClassName:"improving-skills"},r.map(function(e){var t=e.competency,n=e.lastAttemptAt,a=e.readableScore;return i.a.createElement(c.b,{rootClassName:"improving-skill",flexDirection:"column"},i.a.createElement(c.b,{rootClassName:"title",justifyContent:"between"},i.a.createElement("span",{className:"name"},t.name),i.a.createElement("span",{className:"new-score"},h()("New Score"))),i.a.createElement(I.a,{name:t.name,readableScore:a,lastAttemptAt:n}))}))),i.a.createElement(c.b,{rootClassName:"notification-controls",justifyContent:"start",alignItems:"center"},i.a.createElement(k.a,{prompt:h()("Was this useful?"),feedbackKey:"skills_post_assessment_feedback"}),i.a.createElement(m.a,{type:"icon",size:"zero",svgElement:i.a.createElement(f.a,{size:28,color:d.b.bgGrayThemeMid}),onClick:a})))}return null})};e.a=N},NIWx:function(module,exports,e){},QTif:function(module,exports,e){var t=e("NIWx"),n;"string"==typeof t&&(t=[[module.i,t,""]]);var a={transform:void 0},r=e("aET+")(t,a);t.locals&&(module.exports=t.locals)},"T/DQ":function(module,exports,e){},UUa2:function(module,e,t){"use strict";var n=t("sbe7"),a=t.n(n),r=t("w/1P"),i=t.n(r),s=t("6gRZ"),o=t.n(s),u=t("TOZ3"),l=t("+tyo"),c=t.n(l),m=t("QTif"),d=t.n(m),f=function SkillLevelProgressIndicator(e){var t=e.scoreSkillLevel,n=e.skillLevel,r=e.left,o=e.readableScore,l=t===n,m=a.a.createElement("div",{className:i()({indicator:l}),style:{left:"calc(".concat(r,"% - 5px)")}}),d=a.a.createElement(s.Tooltip,{className:"skill-score-tooltip"},a.a.createElement(u.b,{flexDirection:"column"},a.a.createElement("span",{className:"score"},o),a.a.createElement("span",{className:"description"},c()("Your Score")))),f=a.a.createElement(s.OverlayTrigger,{placement:"top",overlay:d},m),v=l?f:m;return a.a.createElement("div",{className:"rc-SkillLevelProgressIndicator"},v)};e.a=f},"XC/k":function(module,e,t){"use strict";t.d(e,"a",function(){return a}),t.d(e,"b",function(){return r});var n=t("KMW/"),a=function isLoggedInHomeSkillsProfileEnabled(){return n.a.get("Skills","lidbSkillsProfileEnabled")||n.a.get("Skills","lidbSkillsIncrementalUser")},r=function isPostAssessmentSkillChangeNotificationEnabled(){return n.a.get("Skills","lidbSkillsProfileEnabled")||n.a.get("Skills","lidbSkillsIncrementalUser")}},"aBK/":function(module,e,t){"use strict";t.d(e,"a",function(){return f});var n=t("VkAN"),a=t.n(n),r=t("sbe7"),i=t.n(r),s=t("lTCR"),o=t.n(s),u=t("oJmH"),l=t.n(u),c=t("TUhR");function _templateObject2(){var e=a()(['\n  query QuizDataQuery(\n    $sessionId: String!\n    $questionDataArgs: String!\n    $responseDataArgs: String!\n    $skipFetchingResponses: Boolean!\n  ) {\n    quizQuestionData(sessionId: $sessionId, questionDataArgs: $questionDataArgs)\n      @rest(\n        type: "QuizQuestionData"\n        path: "onDemandExamSessions.v1/{args.sessionId}/actions"\n        method: "POST"\n        bodyKey: "questionDataArgs"\n      ) {\n      elements @type(name: "RestQuizQuestionDataElement") {\n        id\n        result @type(name: "RestQuizQuestionDataElementResult") {\n          questions\n          nextSubmissionDraftId\n          evaluation\n          responses(sessionId: $sessionId, responseDataArgs: $responseDataArgs)\n            @skip(if: $skipFetchingResponses)\n            @rest(\n              type: "QuizResponseData"\n              path: "onDemandExamSessions.v1/{args.sessionId}/actions"\n              method: "POST"\n              bodyKey: "responseDataArgs"\n            ) {\n            elements @type(name: "RestQuizResponseDataElement") {\n              id\n              result\n            }\n          }\n        }\n      }\n    }\n  }\n']);return _templateObject2=function _templateObject2(){return e},e}function _templateObject(){var e=a()(['\n  query QuizSessionMetaDataQuery($body: String!) {\n    quizSessionMetaData(body: $body)\n      @rest(type: "RestQuizSessionMetadata", path: "onDemandExamSessions.v1", method: "POST", bodyKey: "body") {\n      elements @type(name: "RestQuizSessionMetadataElement") {\n        id\n      }\n    }\n  }\n']);return _templateObject=function _templateObject(){return e},e}var m=o()(_templateObject()),d=o()(_templateObject2()),f=function QuizData(e){var t=e.courseId,n=e.itemId,a=e.examSessionId,r=e.children,s=e.onQuizSessionQueryCompleted,o={courseId:t,itemId:n},l={argument:[],name:"getState"},f={argument:[],name:"getLatestSubmissionDraft"};return i.a.createElement(u.Query,{query:m,variables:{body:o},onCompleted:s,skip:!!a},function(e){var t=e.loading,n=e.data,s=e.refetch;if(t&&!a)return r({loading:t});var o=a||n.quizSessionMetaData.elements[0].id;return i.a.createElement(u.Query,{query:d,variables:{sessionId:o,questionDataArgs:l,responseDataArgs:f,skipFetchingResponses:!!a}},function(e){var t=e.loading,n=e.data,i=e.refetch,u=e.client;if(t)return r({loading:t});var l=n.quizQuestionData.elements[0].result,m=l.questions,d=l.responses,f=l.nextSubmissionDraftId,v=l.evaluation,p=((((((d||{}).elements||[])[0]||{}).result||{}).draft||{}).input||{}).responses,b=Object(c.a)(m,p,!!a),g=v&&v.score/v.maxScore,S=(v||{}).maxScore||b.reduce(function(e,t){return e+t.prompt.weightedScoring.maxScore},0),I=!m[0].isSubmitAllowed,k="NoDetails"===m[0].variant.detailLevel,y,E;return r({loading:t,quizFormData:b,sessionId:o,nextSubmissionDraftId:f,isSubmitted:I,isLimitedFeedback:k,attemptScore:g,totalPoints:S,hasDraft:!!p,refetchQuizData:function refetchQuizData(){return s().then(function(){return i()})},client:u})})})},v=f},bHVB:function(module,exports,e){},bv1f:function(module,e,t){"use strict";var n=t("VkAN"),a=t.n(n),r=t("sbe7"),i=t.n(r),s=t("lTCR"),o=t.n(s),u=t("oJmH"),l=t.n(u);function _templateObject(){var e=a()(['\n  mutation QuizActions($sessionId: String!, $body: String!, $skipQuestionsField: Boolean!, $additionalParams: String!) {\n    action(sessionId: $sessionId, body: $body, additionalParams: $additionalParams)\n      @rest(\n        type: "QuizActionData"\n        path: "onDemandExamSessions.v1/{args.sessionId}/actions{args.additionalParams}"\n        method: "POST"\n        bodyKey: "body"\n      ) {\n      elements @type(name: "RestQuizQuestionDataElement") {\n        id\n        result @type(name: "RestQuizQuestionDataElementResult") {\n          nextSubmissionDraftId\n          evaluation\n          questions @skip(if: $skipQuestionsField)\n        }\n      }\n    }\n  }\n']);return _templateObject=function _templateObject(){return e},e}var c=o()(_templateObject()),m=function getSaveDraftMutation(e){return function(t,n,a,r){return e({variables:{body:{argument:{id:t,input:{responses:a}},name:"saveSubmissionDraft"},sessionId:n,skipQuestionsField:!0,additionalParams:r?"?isAutoSaving=true":""}})}},d=function getSubmitDraftMutation(e){return function(t,n){return e({variables:{body:{argument:{responses:n},name:"submitResponses"},sessionId:t,skipQuestionsField:!1,additionalParams:""}})}},f=function getAutoSubmitDraftMutation(e){return function(t){return e({variables:{body:{argument:{},name:"submitLatestSubmissionDraft"},sessionId:t,skipQuestionsField:!1,additionalParams:""}})}},v=function QuizMutations(e){var t=e.children;return i.a.createElement(u.Mutation,{mutation:c},function(e){var n=m(e),a=d(e),r=f(e);return t({saveDraftMutation:n,submitDraftMutation:a,autoSubmitDraftMutation:r})})};e.a=v},cOLe:function(module,exports,e){var t=e("454o"),n;"string"==typeof t&&(t=[[module.i,t,""]]);var a={transform:void 0},r=e("aET+")(t,a);t.locals&&(module.exports=t.locals)},es0X:function(module,e,t){"use strict";t.r(e);var n=t("sbe7"),a=t.n(n),r=t("PDuk"),i=t.n(r),s=t("zaiP"),o=t("LHEl"),u=t("vTTJ"),l=function SubmittedAttemptPage(){return a.a.createElement(s.a,null,function(e){var t=e.item;if(!t||!t.contentSummary)return null;return a.a.createElement(o.a,{courseId:t.courseId,itemId:t.id},function(e){var n=e.loading,i=e.lastSessionId;if(n)return null;var s=Object(r.tupleToStringKey)([t.courseId,t.id,i]);return a.a.createElement(u.default,{examSessionId:s})})})};e.default=l},flPG:function(module,exports,e){var t=e("yZNc"),n;"string"==typeof t&&(t=[[module.i,t,""]]);var a={transform:void 0},r=e("aET+")(t,a);t.locals&&(module.exports=t.locals)},"iY+7":function(module,e,t){"use strict";var n=t("sbe7"),a=t.n(n),r=t("w/1P"),i=t.n(r),s=t("2jzc"),o=t("UUa2"),u=t("TOZ3"),l=t("cOLe"),c=t.n(l),m=function SkillLevelGraph(e){var t=e.readableScore,n=e.skillLevel,r=3*t,l=(t-s.g.Beginner)*(100/(s.g.Intermediate-s.g.Beginner)),c=(t-s.g.Intermediate)*(100/(s.g.Advanced-s.g.Intermediate));return a.a.createElement(u.b,{rootClassName:"rc-SkillLevelGraph",flexDirection:"column"},a.a.createElement(u.b,{rootClassName:"skill-indicator",justifyContent:"around",alignItems:"end"},a.a.createElement(o.a,{scoreSkillLevel:s.a.Beginner,skillLevel:n,left:r,readableScore:t}),a.a.createElement(o.a,{scoreSkillLevel:s.a.Intermediate,skillLevel:n,left:l,readableScore:t}),a.a.createElement(o.a,{scoreSkillLevel:s.a.Advanced,skillLevel:n,left:c,readableScore:t})),a.a.createElement(u.b,{rootClassName:"bars",justifyContent:"around"},a.a.createElement("div",{className:i()("level-bar","beginner",{active:n===s.a.Beginner})}),a.a.createElement("div",{className:i()("level-bar","intermediate",{active:n===s.a.Intermediate})}),a.a.createElement("div",{className:i()("level-bar","advanced",{active:n===s.a.Advanced})})),a.a.createElement(u.b,{rootClassName:"legend",justifyContent:"around"},a.a.createElement("div",{className:"level-bar"},"0"),a.a.createElement("div",{className:"level-bar"},"30"),a.a.createElement("div",{className:"level-bar"},"70")),a.a.createElement(u.b,{rootClassName:"legend description",justifyContent:"around"},a.a.createElement("div",{className:"level-bar"},s.a.Beginner),a.a.createElement("div",{className:"level-bar"},s.a.Intermediate),a.a.createElement("div",{className:"level-bar"},s.a.Advanced)))};e.a=m},oKlG:function(module,exports){exports.default={"ar":true,"de":true,"es":true,"fr":true,"ja":true,"ko":true,"pt":true,"ru":true,"zh":true,"zh-hk":"zh-tw","zh-mo":"zh-tw","zh-tw":true}},uAMc:function(module,e,t){"use strict";var n=t("sbe7"),a=t.n(n),r=t("agp5"),i=t("RH4a"),s=t("0n3a"),o=t("zaiP"),u=t("LHEl"),l=t("wjH1"),c=t("bv1f"),m=function QuizActions(e){var t=e.ids,n=e.sessionId,m=e.children,d=e.nextSubmissionDraftId;return a.a.createElement(o.a,null,function(e){var o=e.item;if(!o)return null;var f=o.courseId,v=o.id;return a.a.createElement(u.a,{courseId:f,itemId:v},function(e){var u=e.refetch;return a.a.createElement(r.a,{ids:t},function(e){if(!e||!u)return m({});var t=e.some(function(e){return!(((e||{}).response||{}).definition||{}).value});return a.a.createElement(i.a,{itemId:v,courseId:f},function(r){var i=r.stepState,f=r.setStepState;return a.a.createElement(c.a,null,function(r){var c=r.saveDraftMutation,v=r.submitDraftMutation,p=r.autoSubmitDraftMutation,b=e.map(function(e){return{questionInstance:e.id,response:((e.response||{}).definition||{}).value}}),g=function saveDraft(){if(!i.isSaving&&!i.isSubmitting&&d)return f({isSaving:!0}),c(d,n,b).then(function(){return f({isSaving:!1})}).catch(function(e){return Object(l.a)(e,f)});return Promise.reject()},S=function autoSaveDraft(){if(!i.isAutoSaving&&!i.isSubmitting&&d)return f({isAutoSaving:!0}),c(d,n,b,!0).then(function(){return f({isAutoSaving:!1})}).catch(function(e){return Object(l.a)(e,f)});return Promise.reject()},I=function refetchItemAndExamSummary(){return u().then(function(){return o.refetch()})},k=function submitDraft(){if(!i.isSubmitting)return f({isSubmitting:!0}),v(n,b).then(function(){return f({isSubmitting:!1})}).then(I).catch(function(e){return Object(l.a)(e,f)});return Promise.reject()},y=function submitLatestSubmissionDraft(){if(!i.isSubmitting)return f({isSubmitting:!0}),p(n).then(function(){return f({isSubmitting:!1})}).then(I).catch(function(e){return Object(l.a)(e,f)});return Promise.reject()};return a.a.createElement(s.a,{stepState:i,saveDraft:S,changedResponses:e},function(){return m({hasUnfilledResponses:t,saveDraft:g,autoSaveDraft:S,submitDraft:k,submitLatestSubmissionDraft:y})})})})})})})};e.a=m},"v4A+":function(module,e,t){"use strict";var n=t("VkAN"),a=t.n(n),r=t("sbe7"),i=t.n(r),s=t("lTCR"),o=t.n(s),u=t("oJmH"),l=t.n(u),c=t("++C6");function _templateObject(){var e=a()(["\n  query PostQuizHelpQuery($courseId: String!, $itemId: String!) {\n    PostQuizHelpV1 @naptime {\n      byCourseItemId(courseId: $courseId, itemId: $itemId) {\n        elements {\n          id\n          courseId\n          courseBranchId\n          versionedQuestionId\n          versionedAssessmentId\n          suggestedItems {\n            suggestedItemId\n            itemDetails {\n              typeName\n              definition\n            }\n            timeCommitment\n            title\n            url\n          }\n        }\n      }\n    }\n  }\n"]);return _templateObject=function _templateObject(){return e},e}var m=o()(_templateObject()),d=function reshapeSuggestion(e){var t,n,a,r,i;return{id:e.suggestedItemId,title:e.title,typeName:e.itemDetails.typeName,timeCommitment:e.timeCommitment,url:e.url}},f=function PostQuizHelpProvider(e){var t=e.courseId,n=e.itemId,a=e.children;return i.a.createElement(u.Query,{query:m,variables:{courseId:t,itemId:n},skip:!Object(c.a)(t)},function(e){var n,r,i=e.loading,s=e.error,o=e.data;if(!Object(c.a)(t))return a({error:!1,loading:!1});if(s||i)return a({error:!!s,loading:i});var u,l=((null==o?void 0:null===(n=o.PostQuizHelpV1)||void 0===n?void 0:null===(r=n.byCourseItemId)||void 0===r?void 0:r.elements)||[]).map(function(e){return{id:e.id,courseId:e.courseId,courseBranchId:e.courseBranchId,versionedQuestionId:e.versionedQuestionId,versionedAssessmentId:e.versionedAssessmentId,suggestedItems:e.suggestedItems.map(d)}});return a({postQuizSuggestions:l,error:!1,loading:i})})};e.a=f},vTTJ:function(module,e,t){"use strict";t.r(e),t.d(e,"AttemptPage",function(){return L}),t.d(e,"withRedirectToCover",function(){return R});var n=t("VbXa"),a=t.n(n),r=t("sbe7"),i=t.n(r),s=t("MnCE"),o=t("EqTq"),u=t("m10x"),l=t("+LJP"),c=t("usGt"),m=t("LHEl"),d=t("oe9u"),f=t("/oRK"),v=t("XFHP"),p=t("22Sa"),b=t("eK4/"),g=t("aBK/"),S=t("uAMc"),I=t("RH4a"),k=t("zaiP"),y=t("wIYG"),E=t("kYu0"),h=t("4QSv"),D=t("8ec0"),C=t("l0R+"),A=t("XC/k"),N=t("L2S7"),P=t("v4A+"),Q=t("GZYn"),T=t("VtNW"),j=t.n(T),O=t("3AUy"),z=t.n(O),x=Object(o.a)("AttemptPage"),L=function(e){function AttemptPage(){for(var t,n=arguments.length,a=new Array(n),r=0;r<n;r++)a[r]=arguments[r];return(t=e.call.apply(e,[this].concat(a))||this).state={showSkillsNotification:!0},t.dismissSkillsNotification=function(){t.setState({showSkillsNotification:!1})},t}a()(AttemptPage,e);var t=AttemptPage.prototype;return t.componentDidMount=function componentDidMount(){var e=this.props,t=e.shouldRedirectToCover,n=e.redirectToCover;t&&n()},t.render=function render(){var e=this,t=this.props,n=t.redirectToCover,a=t.addRedirectToCoverToRouteParams,r=t.examSessionId,s=this.state.showSkillsNotification;return i.a.createElement(k.a,null,function(t){var o=t.item;if(!o)return null;return i.a.createElement(E.a,{standardProctorConfigurationId:o.contentSummary&&"exam"===o.contentSummary.typeName&&o.contentSummary.definition.standardProctorConfigurationId||null},function(t){var l=t.shouldShowTimer,c=t.secondsLeftInLatestAttempt,k=t.refetch,E=t.remainingAttempts;return i.a.createElement(p.a,{onClose:n,headerLeft:i.a.createElement(d.a,{headerText:o.name,itemTypeText:j()("Graded Quiz"),timeCommitment:o.timeCommitment}),headerRight:i.a.createElement(g.a,{courseId:o.courseId,itemId:o.id,examSessionId:r},function(e){var t=e.isSubmitted;return i.a.createElement(f.a,{deadline:o.deadline,remainingTimeInMs:"number"==typeof c?1e3*c:null,showTimer:l&&!t,timerId:Object(D.a)(o.id)})}),topBanner:i.a.createElement(g.a,{courseId:o.courseId,itemId:o.id,examSessionId:r},function(t){var a=t.isSubmitted,r,u=(o.contentSummary&&"exam"===o.contentSummary.typeName&&o.contentSummary.definition||{}).passingFraction;if(a&&o.itemGrade){var l,c=(o.itemGrade||{}).isPassed,d=Object(Q.b)(c,o.isCumulativeGraded,E);return i.a.createElement(m.a,{courseId:o.courseId,itemId:o.id},function(t){var a=t.lockingConfigurationSummary,r=t.bestEvaluation;return i.a.createElement("div",null,i.a.createElement(h.a,{itemGrade:o.itemGrade,computedScore:(r||{}).score,maxScore:(r||{}).maxScore,passingFraction:u,isCumulativeGraded:o.isCumulativeGraded,onKeepLearningClick:n,remainingAttempts:E,lockingConfigurationSummary:a,onTryAgainClick:n}),Object(A.b)()&&s&&d===Q.a.PASSED&&i.a.createElement(N.a,{onDismiss:e.dismissSkillsNotification,courseId:o.courseId,itemId:o.id}))})}return null})},i.a.createElement(P.a,{courseId:o.courseId,itemId:o.id},function(e){var t=e.postQuizSuggestions,n=e.loading;return i.a.createElement(g.a,{courseId:o.courseId,itemId:o.id,onQuizSessionQueryCompleted:function onQuizSessionQueryCompleted(){return k()},examSessionId:r},function(e){var r=e.quizFormData,s=e.sessionId,c=e.nextSubmissionDraftId,m=e.attemptScore,d=e.totalPoints,f=e.isSubmitted,p=e.hasDraft,g=e.isLimitedFeedback;if(!r||n||!s)return i.a.createElement(y.a,null);if(g)return null;var k=r.map(function(e){return e.prompt.id});return i.a.createElement(I.a,{itemId:o.id,courseId:o.courseId},function(e){var n=e.stepState,g=e.setStepState;return i.a.createElement("div",{className:x()},i.a.createElement("div",{className:x("header")},i.a.createElement(u.d,null,o.name),f&&"number"==typeof m?i.a.createElement("div",{className:x("submission-grade")},i.a.createElement(u.h,{tag:"span"},j()("Latest Submission Grade")),i.a.createElement("div",{className:x("grade-percent")},"".concat(Object(C.a)(m),"%"))):i.a.createElement(u.a,{rootClassName:x("points")},i.a.createElement(u.h,{tag:"span"},j()("Total points #{totalPoints}",{totalPoints:d})))),i.a.createElement("div",{className:x("prompts")},r.map(function(e,a){return i.a.createElement(b.a,{key:e.prompt.id,quizQuestion:e,postQuizSuggestions:(f&&t||[]).find(function(t){return t.id===e.prompt.id}),index:a,isReadOnly:!!f,isDisabled:!!(n||{}).isSaving||!!(n||{}).isSubmitting})})),i.a.createElement(S.a,{ids:k,sessionId:s,nextSubmissionDraftId:c},function(e){var t=e.hasUnfilledResponses,r=e.saveDraft,s=e.autoSaveDraft,u=e.submitDraft,c=e.submitLatestSubmissionDraft;return i.a.createElement(v.a,{hasUnfilledResponses:t,itemId:o.id,courseId:o.courseId,saveDraft:r,autoSaveDraft:s,isSubmitted:f,submitDraft:function submitDraft(){return u?u().then(function(){a()}):Promise.reject()},submitLatestSubmissionDraft:function submitLatestSubmissionDraft(){return c?c().then(function(){a()}):Promise.reject()},hasTimer:l,hasDraft:p,stepState:n,setStepState:g})}))})})}))})})},AttemptPage}(i.a.Component),R=Object(s.compose)(c.a,Object(l.a)(function(e,t){var n=t.refetchCoverPageData,a=t.refreshProgress;return{redirectToCover:function redirectToCover(){n&&n(),e.push({name:"quiz-cover",params:e.params,query:e.location.query}),a()},addRedirectToCoverToRouteParams:function addRedirectToCoverToRouteParams(){e.push({name:"quiz-attempt",params:e.params,query:{redirectToCover:!0}})},shouldRedirectToCover:e.location.query.redirectToCover}}));e.default=R(L)},w7Dv:function(module,exports,e){var t=e("T/DQ"),n;"string"==typeof t&&(t=[[module.i,t,""]]);var a={transform:void 0},r=e("aET+")(t,a);t.locals&&(module.exports=t.locals)},xanp:function(module,e,t){"use strict";var n=t("VbXa"),a=t.n(n),r=t("sbe7"),i=t.n(r),s=t("w/1P"),o=t.n(s),u=t("AWZ4"),l=t("TOZ3"),c=t("Ihj9"),m=t("v8wb"),d=t("+tyo"),f=t.n(d),v=t("w7Dv"),p=t.n(v),b=Object(c.a)({type:"BUTTON"})(u.b),g=function(e){function SkillsYesNoFeedback(t){var n,a,r;r=e.call(this,t)||this;var i=t.feedbackKey,s=null===(n=window)||void 0===n?void 0:null===(a=n.localStorage)||void 0===a?void 0:a.getItem(i);return r.state={feedbackComplete:!!s},r}a()(SkillsYesNoFeedback,e);var t=SkillsYesNoFeedback.prototype;return t.saveFeedback=function saveFeedback(e){var t=this.props.feedbackKey;window.localStorage.setItem(t,e),this.setState({feedbackComplete:!0})},t.render=function render(){var e=this,t=this.props,n=t.feedbackKey,a=t.prompt,r=this.state.feedbackComplete;return i.a.createElement(l.b,{rootClassName:o()("rc-SkillsYesNoFeedback",{"fade-out":r}),flexDirection:"row",alignItems:"center",htmlAttributes:{"aria-hidden":r}},a,i.a.createElement(b,{rootClassName:"skills-feedback-button skills-feedback-button-yes",type:"secondary",onClick:function onClick(){e.saveFeedback("yes")},trackingName:n,trackingData:{value:"yes"},label:f()("Yes"),size:"zero"}),i.a.createElement(b,{rootClassName:"skills-feedback-button skills-feedback-button-no",type:"secondary",onClick:function onClick(){e.saveFeedback("no")},trackingName:n,trackingData:{value:"no"},label:f()("No"),size:"zero"}))},SkillsYesNoFeedback}(i.a.Component),S=function CSROnlySkillsYesNoFeedback(e){return i.a.createElement(m.default,null,i.a.createElement(g,e))};e.a=S},yZNc:function(module,exports,e){}}]);
//# sourceMappingURL=en.65.cf40f142ca2412392224.js.map