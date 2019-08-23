import os
def load_data(path):
    """
    load data
    """
    input_file=os.path.join(path)
    with open(input_file,"r") as f:
        data=f.read()
        
    return data.split('\n')