# Use an official Node.js runtime as a base image
FROM node:14

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install application dependencies
RUN npm install

# Copy the entire application to the working directory
COPY . .

# Build the Angular app (modify this based on your frontend framework)
RUN npm run build

# Expose the ports the app runs on
EXPOSE 4200

# Define the command to run your application
CMD ["npm", "start"]
