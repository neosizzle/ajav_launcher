git clone https://github.com/Homebrew/brew.git
echo 'export PATH="$PWD/brew/bin:$PATH"' >> ~/.bash_profile
source ~/.bash_profile
brew update
brew install java
echo 'export PATH="$PWD/brew/opt/openjdk/bin:$PATH"' >> ~/.bash_profile
source ~/.bash_profile
java --version