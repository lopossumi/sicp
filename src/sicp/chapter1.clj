;;; Exercise 1.3 : Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers.

(defn square [x] (* x x))
(defn cube [x] (* x x x))

(defn abs 
    [x] 
    (if (< x 0) (- x) 
                x))

(defn sum-largest-squares
    "Returns the sum of the squares of the two largest numbers."
    [& nums]
    ; Sort, take two largest, square them and return sum.
    (->> (sort nums)
         (take-last 2)
         (map square)
         (reduce +)))

;;; Exercise 1.8 : Implement a cube-root procedure analogous to the square-root procedure.

(defn good-enough?
    [guess x]
    (> 0.001 (abs (- (cube guess) x))))

(defn improve
    [guess x]
    (/  (+ (/ x (square guess)) (* 2 guess))
        3))

(defn cube-root
    [x]
    (defn cube-root-iter [guess]
        (if (good-enough? guess x)  
            guess
            (cube-root-iter (improve guess x))))
    (cube-root-iter 1.0))

;;; Exercise 1.9 : Iterative or recursive?
; (define (+ a b)
;     (if (= a 0) b
;                 (inc (+ (dec a) b))))
; (+ 4 5)
; (inc (+ (dec 4) 5))
; (inc (+ 3 5))
; (inc (inc (+ (dec 3) 5)))
; (inc (inc (+ 2 5)))
; (inc (inc (inc (+ (dec 2) 5))))
; ... recursive.

; (define (+ a b)
;     (if (= a 0)
;         b
;         (+ (dec a) (inc b))))
; (+ 4 5)
; (+ (dec 4) (inc 5))
; (+ 3 6)
; (+ (dec 3) (inc 6))
; (+ 2 7)
; (+ (dec 2) (inc 7))
; + 1 8)
; ... iterative.
