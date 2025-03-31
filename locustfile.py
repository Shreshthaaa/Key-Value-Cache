from locust import HttpUser, task, between

class KeyValueTest(HttpUser):
    wait_time = between(1, 3)  # Simulate real-world user wait time between requests

    @task(2)  # This task runs twice as often as the get request
    def put_request(self):
        self.client.post("/put", json={"key": "testKey", "value": "testValue"})

    @task(1)
    def get_request(self):
        self.client.get("/get", params={"key": "testKey"})
