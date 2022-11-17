import json
import math
with open("history.json") as file:
     load_dict = json.load(file)
     # print(load_dict['data']['result'])
     print("job,value")
     for obj in load_dict['data']['result']:
          print(obj['metric']['job']+","+obj['value'][1])
     math.sqrt(2)
          