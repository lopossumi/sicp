; Exercise 1.3 : Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers.

(defn square
    [x]
    (* x x))

(defn sum-largest-squares
    "Returns the sum of the squares of the two largest numbers."
    [& nums]
    ;; Sort, take two largest, square them and return sum.
    (->>    (sort nums)
            (take-last 2)
            (map square)
            (reduce +)))
