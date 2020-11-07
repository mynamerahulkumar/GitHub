from pytube import YouTube
yt = YouTube("https://www.youtube.com/watch?v=l8bqPrenI0A&feature=youtu.be&ab_channel=BYJU%27SIAS")
yt = yt.get('mp4', '720p')
yt.download('/path/to/download/directory')