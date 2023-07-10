package com.eats.restaurant;

public class Generalutil {
    public static void main(String[] args) {
        System.out.println("22");
        String xmlMessage="<gce><Cdtragt><FinInstand> <BICFI>OHHOVGV</Cdtragt></FinInstand></BICFI>";
        String searchstr="<Cdtragt><FinInstand><BIC>";
        String laststr="</Cdtragt></FinInstand></BIC>";
        System.out.println(xmlMessage);
        String newxml=xmlMessage.replaceAll("\\s","").replaceAll("\\.","");
        System.out.println(newxml);
        String bic=null;
        Generalutil generalutil=new Generalutil();
        bic=generalutil.getMessageId(newxml,searchstr,laststr);
        if("NULL".equals(bic)){
             xmlMessage="<gce><Cdtragt><FinInstand> <BICFI>OHHOVGV</Cdtragt></FinInstand></BICFI>";
             searchstr="<Cdtragt><FinInstand><BICFI>";
             laststr="</Cdtragt></FinInstand></BICFI>";
            bic=generalutil.getMessageIdbicfi(newxml,searchstr,laststr);
            System.out.println("bci-"+bic);
        }
        else{
            System.out.println("could not search");
        }

    }
    public String getMessageId(final  String xmlMessage,final  String first ,final String second){
        final int searchlen=first.length();
        String messageId="NULL";
        int indexref;
        if(!(null==xmlMessage)){
            indexref=xmlMessage.indexOf(first);
            if(indexref!=-1){
                int beginptr=indexref+searchlen;
                messageId=xmlMessage.substring(beginptr,xmlMessage.indexOf(second,beginptr+1));
            }
        }
        return messageId;
    }
    public String getMessageIdbicfi(final  String xmlMessage,final  String first ,final String second){
        final int searchlen=first.length();
        String messageId="NULL";
        int indexref;
        if(!(null==xmlMessage)){
            indexref=xmlMessage.indexOf(first);
            if(indexref!=-1){
                int beginptr=indexref+searchlen;
                messageId=xmlMessage.substring(beginptr,xmlMessage.indexOf(second,beginptr+1));
            }
        }
        return messageId;
    }
}
