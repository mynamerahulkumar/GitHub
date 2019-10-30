import webbrowser

query = input()
url = "https://www.google.co.in/search?q=" + (str(query)) + "&oq=" + (
    str(query)) + "&gs_l=serp.12..0i71l8.0.0.0.6391.0.0.0.0.0.0.0.0..0.0....0...1c..64.serp..0.0.0.UiQhpfaBsuU"

webbrowser.open(url)