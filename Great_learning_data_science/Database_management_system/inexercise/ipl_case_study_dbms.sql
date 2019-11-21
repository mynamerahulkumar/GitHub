use ipl;
show tables ;
#Questions – Write SQL queries to get data for following requirements:
/*
 1.	Show the percentage of wins of each bidder in the order of highest to lowest percentage.
 */

select Bidder_id,count(*)*100.0/(select count(* ) from IPL_Bidding_Details ibd2 where ibd.Bidder_id=ibd2.Bidder_id)
    total_per_win from IPL_Bidding_Details ibd where bid_status='Won' group by Bidder_id order by  total_per_win desc ;
/*
 2.	Which teams have got the highest and the lowest no. of bids?
 */
 select ibd.bid_team,sum(ibp.no_of_bids) total_bids from IPL_Bidding_Details ibd join IPL_Bidder_Points ibp on
     ibd.bidder_Id=ibp.bidder_Id group by ibd.bid_Team order by total_bids desc   ;

 select ibd.bid_team,sum(ibp.no_of_bids) total_bids from IPL_Bidding_Details ibd join IPL_Bidder_Points ibp on
     ibd.bidder_Id=ibp.bidder_Id group by ibd.bid_Team order by total_bids  limit 1 ;



 select ibd.bid_team from IPL_Bidding_Details ibd join IPL_Bidder_Points ibp on
     ibd.bidder_Id=ibp.bidder_Id group by ibd.bid_team having sum(ibp.no_of_bids) in (

 (select sum(ibp.no_of_bids) total_bids from IPL_Bidding_Details ibd join IPL_Bidder_Points ibp on
     ibd.bidder_Id=ibp.bidder_Id group by ibd.bid_Team order by total_bids desc  limit 1),

(select sum(ibp.no_of_bids) total_bids from IPL_Bidding_Details ibd join IPL_Bidder_Points ibp on
     ibd.bidder_Id=ibp.bidder_Id group by ibd.bid_Team order by total_bids   limit 1));
/*
 3.	In a given stadium, what is the percentage of wins by a team which had won the toss?
 */
#select im.Stadium_id,im.Match_id,count(*) total_match from IPL_match_schedule im group by im.Stadium_id, im.Match_id;
select ims.Stadium_id ,(select count(ims1.Match_id) total_wins from IPL_match_schedule ims1  join ipl_match im1 on
    im1.match_id =ims1.match_id where ims.Stadium_id=ims1.Stadium_id and im1.toss_winner=im1.match_winner group by ims1.stadium_id
)*100/count(ims.Match_id) per_win from IPL_match_schedule ims  group by ims.stadium_id;
#select count(ims1.Match_id) total_wins from IPL_match_schedule ims1  join ipl_match im1 on im1.match_id =ims1.match_id group by ims1.stadium_id;


/*
 4.	What is the total no. of bids placed on the team that has won highest no. of matches?
 */
select sum(ibp.no_of_bids) total_no_bids from IPL_Bidding_Details ibd join IPL_Bidder_Points ibp on
     ibd.bidder_Id=ibd.bidder_Id where ibd.bid_team=(
select its.team_id from IPL_Team_Standings its group by its.Team_id having sum(its.Matches_won)=(
 select sum(its.Matches_won) total_won from IPL_Team_Standings its group by its.Team_id order by  total_won desc limit 1));

/*
 5.	From the current team standings, if a bidder places a bid on which of the teams,
 there is a possibility of (s)he winning the highest no. of points – in simple words,
 identify the team which has the highest jump in its total points (in terms of percentage)
 from the previous year to current year.
 */
#select ibd.bid_team,sum(ibp.total_points) total_points from IPL_Bidding_Details ibd join IPL_Bidder_Points ibp on
 #    ibd.bidder_Id=ibd.bidder_Id where year(ibd.bid_date)=(year(curdate())-1) group by ibd.bid_team ;
select ibd1.bid_team,sum(ibp1.total_points)-(select sum(ibp.total_points)  from IPL_Bidding_Details ibd join IPL_Bidder_Points ibp on
     ibd.bidder_Id=ibd.bidder_Id where year(ibd.bid_date)=(year(curdate())-2) and ibd1.bid_team=ibd.bid_team group by ibd.bid_team )
    total_points_gain from IPL_Bidding_Details ibd1 join IPL_Bidder_Points ibp1 on
     ibd1.bidder_Id=ibd1.bidder_Id where year(ibd1.bid_date)=(year(curdate())-1) group by ibd1.bid_team  order by total_points_gain desc;





