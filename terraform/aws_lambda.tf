resource "aws_iam_role" "iam_for_lambda" {
  name = "iam_for_lambda"

  assume_role_policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": "sts:AssumeRole",
      "Principal": {
        "Service": "lambda.amazonaws.com"
      },
      "Effect": "Allow",
      "Sid": ""
    }
  ]
}
EOF
}
resource "aws_lambda_function" "test_lambda" {
  filename = "D:/New folder/New folder/demo.zip"
  function_name = "lambda_function_name"
  role = aws_iam_role.iam_for_lambda.arn
  runtime = "java11"
  handler = "index.test"
}