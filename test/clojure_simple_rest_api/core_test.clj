(ns clojure-simple-rest-api.core-test
  (:use clojure.test
        ring.mock.request
        clojure-simple-rest-api.core))

(deftest test-app-response-headers
  (testing "test our only endpoint headers"
    (let [response (app (request :get "/test"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello,Test"))
      (is (= (get-in response [:headers "Content-Type"]) "text/html; charset=utf-8")))))

(deftest test-app-response-body
  (testing "test our only endpoint body"
    (let [response (app (request :get "/test"))]
      (is (= (:body response) "Hello,Test")))))