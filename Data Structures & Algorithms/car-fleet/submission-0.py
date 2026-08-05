class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = list(zip(position,speed))
        cars.sort(reverse=True)

        fleets =0 
        previous_time = 0

        for pos, spd in cars:
            time = (target- pos)/spd

            if time > previous_time:
                fleets +=1 
                previous_time = time

        return fleets