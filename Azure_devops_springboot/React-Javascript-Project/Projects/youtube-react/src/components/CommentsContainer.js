
const commentData=[
    {
        name:"Rahul Kumar",
        text:"Lrsps sdg sg Lrsps sdg sg",
        replies:[
            {
                name:"Rahul Kumar",
                text:"Lrsps sdg sg Lrsps sdg sg",
                replies:[
                    {
                        name:"Rahul Kumar",
                        text:"Lrsps sdg sg Lrsps sdg sg",
                        replies:[
                            {
                                name:"Rahul Kumar",
                                text:"Lrsps sdg sg Lrsps sdg sg",
                                replies:[
                                    {
                                        name:"Rahul Kumar",
                                        text:"Lrsps sdg sg Lrsps sdg sg",
                                        replies:[
                                            
                                        ]
                                    },
                                ]
                            },
                        ]
                    },
                ]
            },
        ]
    },
    {
        name:"Akshay Saini",
        text:"Lrsps sdg sg",
        replies:[
            {
                name:"Rahul Kumar",
                text:"Lrsps sdg sg Lrsps sdg sg",
                replies:[
                    {
                        name:"Rahul Kumar",
                        text:"Lrsps sdg sg Lrsps sdg sg",
                        replies:[
                            {
                                name:"Rahul Kumar",
                                text:"Lrsps sdg sg Lrsps sdg sg",
                                replies:[
                                    {
                                        name:"Rahul Kumar",
                                        text:"Lrsps sdg sg Lrsps sdg sg",
                                        replies:[
                                            
                                        ]
                                    },
                                ]
                            },
                        ]
                    },
                ]
            },
        ]
    },
    {
        name:"Akshay Saini",
        text:"Lrsps sdg sg Lrsps sdg sg",
        replies:[
            {
                name:"Rahul Kumar",
                text:"Lrsps sdg sg",
                replies:[
                    
                ]
            },
        ]
    },
    {
        name:"Akshay Saini",
        text:"Lrsps sdg sg",
        replies:[
            {
                name:"Rahul Kumar",
                text:"Lrsps sdg sg",
                replies:[
                    
                ]
            },
        ]
    },
    {
        name:"Rahul Kumar",
        text:"Lrsps sdg sg",
        replies:[
            {
                name:"Rahul Kumar",
                text:"Lrsps sdg sg",
                replies:[
                    
                ]
            },
        ]
    },
    {
        name:"Rahul Kumar",
        text:"Lrsps sdg sg",
        replies:[
            {
                name:"Rahul Kumar",
                text:"Lrsps sdg sg",
                replies:[
                    
                ]
            },
        ]
    },
]
const Comment=({data})=>{
    const{name,text,replies}=data;
    console.log(name);
    return(
        <div className="shadow-sm p-2 bg-gray-100 rounded-lg m-4">
           <img className="h-8 w-8"
           alt='image' src="https://e7.pngegg.com/pngimages/178/595/png-clipart-user-profile-computer-icons-login-user-avatars-monochrome-black-thumbnail.png"/>
        <div className="px-3">
            <p className="font-bold">{name}</p>
            <p>{text}</p>
        </div>
        </div>
    )
}
const CommentList=({comList})=>{
    return comList.map((comment,index)=>(
        <div>
    <Comment data={comment} key={index}/>
    <div className="pl-5 border border-l-black ml-5">
        <CommentList comList={comment.replies}/>
    </div>
    </div>
    
    ))

}

const CommentContainer=()=>{
    return(
        <div className="m-5 p-2">
          <h1 className="text-2xl font-bold">  Comments:</h1>
          <CommentList comList={commentData}/>
        </div>
    )

}
export default CommentContainer;