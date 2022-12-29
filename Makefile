NAME=avaj_launcher
SRCS=src/avaj_launcher.java src/classes/*.java 
JAVAC=javac
JAVAC_FLAGS=-d bundle

# Style constants
RED=\033[0;31m
GREEN=\033[0;32m
YELLOW=\033[0;33m
BLUE=\033[0;34m
PURPLE=\033[0;35m
CYAN=\033[0;36m
NC=\033[0m # No Color

all : ${NAME}
	@echo "${GREEN}✔️  Done compiling.... Run launch.sh to launch${NC}"

${NAME} :
	@echo "${GREEN}📇  Compiling All sources..${NC}"
	@${JAVAC} ${SRCS} ${JAVAC_FLAGS}

fclean :
	@echo "${YELLOW}🗑️  Removing ${NAME}..${NC}"
	@rm -rf bundle

re : fclean all

.PHONY : re clean fclean all