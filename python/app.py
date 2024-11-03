from flask import Flask, request, jsonify

app = Flask(__name__)


@app.route('/process-data', methods=['POST'])
def process_data():
    try:
        data = request.get_json()

        name = data.get('name')
        profession = data.get('profession')

        result = {
            "message": f"Received data for {name}, who is a {profession}."
        }

        return jsonify(result), 200

    except Exception as e:
        return jsonify({"error": str(e)}), 400


if __name__ == '__main__':
    app.run(host="0.0.0.0", port=5000)
